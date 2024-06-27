package farm.program.service;

import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import farm.program.domain.CustomerInfo;
import farm.program.domain.FarmCrops;
import farm.program.domain.FarmInfo;
import farm.program.dto.CustomerInfoDto;
import farm.program.dto.FarmInfoDto;
import farm.program.repository.CustomerInfoRepository;
import farm.program.repository.FarmCropsRepository;
import farm.program.repository.FarmInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class FarmService {

    private final FarmInfoRepository farmInfoRepository;
    private final CustomerInfoRepository customerInfoRepository;
    private final FarmCropsRepository farmCropsRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public FarmService(FarmInfoRepository farmInfoRepository, CustomerInfoRepository customerInfoRepository, FarmCropsRepository farmCropsRepository, MemberRepository memberRepository) {
        this.farmInfoRepository = farmInfoRepository;
        this.customerInfoRepository = customerInfoRepository;
        this.farmCropsRepository = farmCropsRepository;
        this.memberRepository = memberRepository;
    }

//    // 모든 작물 목록 조회
//    public List<FarmCropsDto> getAllCropsDto() {
//        return farmCropsRepository.findAll().stream()
//                .map(FarmCropsDto::fromEntity)
//                .collect(Collectors.toList());
//    }

    // 모든 작물 목록 조회
    public List<String> getAllCrops() {
        return farmCropsRepository.findDistinctCrops();
    }

    // 선택한 작물을 재배하는 농장 목록 조회
    public List<FarmInfoDto> getFarmsByCrop(String crop) {
        if (crop == null || crop.strip().isEmpty()) {
            throw new IllegalArgumentException("작물 이름을 입력해 주세요.");
        }
        List<FarmInfo> farms = farmInfoRepository.findByCrop(crop);
        if (farms.isEmpty()) {
            throw new NoSuchElementException("해당 작물을 재배하는 농장이 없습니다.");
        }
        return farms.stream()
                .map(FarmInfoDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 고객의 농장 예약 신청을 처리
    public CustomerInfoDto applyForProgram(CustomerInfoDto customerDto, String username) {
        if (customerDto == null) {
            throw new IllegalArgumentException("고객 정보가 없습니다.");
        }
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        CustomerInfo customer = new CustomerInfo();
        customer.setName(customerDto.getName());
        customer.setSelectedCrop(customerDto.getSelectedCrop());
        customer.setStatus("신청 완료");
        customer.setMember(member);

        FarmInfo farmInfo = farmInfoRepository.findById(customerDto.getFarmId())
                .orElseThrow(() -> new IllegalArgumentException("해당 농장을 찾을 수 없습니다."));
        customer.setFarmInfo(farmInfo);

        CustomerInfo savedCustomer = customerInfoRepository.save(customer);
        return CustomerInfoDto.fromEntity(savedCustomer);
    }

    // 고객의 예약 상태를 업데이트 (농장주용)
    public CustomerInfoDto updateStatus(Long customerId, String status, String username) {
        if (customerId == null) {
            throw new IllegalArgumentException("고객 ID가 없습니다.");
        }
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("상태 정보가 없습니다.");
        }

        Member farmer = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        CustomerInfo customerInfo = customerInfoRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 고객을 찾을 수 없습니다: " + customerId));

        if (!customerInfo.getFarmInfo().getMember().equals(farmer)) {
            throw new IllegalArgumentException("해당 예약을 처리할 권한이 없습니다.");
        }

        customerInfo.setStatus(status);
        CustomerInfo updatedCustomer = customerInfoRepository.save(customerInfo);
        return CustomerInfoDto.fromEntity(updatedCustomer);
    }

    // 농장 정보 생성 (농장주용)
    public FarmInfoDto createFarmInfo(FarmInfoDto farmInfoDto, String username) {
        Member farmer = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        FarmInfo farmInfo = new FarmInfo();
        farmInfo.setName(farmInfoDto.getName());
        farmInfo.setAddress(farmInfoDto.getAddress());
        farmInfo.setMember(farmer);

        List<FarmCrops> farmCrops = farmInfoDto.getCrops().stream()
                .map(crop -> {
                    FarmCrops farmCrop = new FarmCrops();
                    farmCrop.setCrops(crop);
                    farmCrop.setFarmInfo(farmInfo);
                    return farmCrop;
                })
                .collect(Collectors.toList());

        farmInfo.setFarmCrops(farmCrops);

        FarmInfo savedFarmInfo = farmInfoRepository.save(farmInfo);
        return FarmInfoDto.fromEntity(savedFarmInfo);
    }

    public List<CustomerInfo> getAllCustomer(String name) {
        Member member = findMember(name);
        FarmInfo farm = findFarm(member);
        return findCustomer(farm);
    }

    public Set<FarmInfo> getAllFarm(String name){
        Member member = findMember(name);
        return member.getFarmInfos();
    }

    private Member findMember(String name) {
        return memberRepository.findByUsername(name).orElseThrow(() -> new NoSuchElementException("멤버 없음"));
    }

    private FarmInfo findFarm(Member member) {
        return farmInfoRepository.findByMemberId(member.getId()).orElseThrow(() -> new NoSuchElementException("농장 없음"));
    }

    private List<CustomerInfo> findCustomer(FarmInfo farm){
        return customerInfoRepository.findByFarmInfoId(farm.getId());
    }
}