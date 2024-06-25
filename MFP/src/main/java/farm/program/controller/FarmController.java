package farm.program.controller;

import farm.program.dto.CustomerInfoDto;
import farm.program.dto.FarmInfoDto;
import farm.program.service.FarmService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/program")
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // 모든 작물 목록 조회
    @GetMapping("/crops")
    public ResponseEntity<?> getAllCrops() {
        try {
            List<String> crops = farmService.getAllCrops();
            if (crops.isEmpty()) {
                return ResponseUtil.noContent("등록된 작물이 없습니다.");
            }
            return ResponseUtil.ok(crops);
        } catch (Exception e) {
            return ResponseUtil.serverError("작물 목록 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 선택한 작물을 재배하는 농장 목록 조회
    @GetMapping("/farms")
    public ResponseEntity<?> getFarmsByCrop(@RequestParam String crop) {
        try {
            List<FarmInfoDto> farms = farmService.getFarmsByCrop(crop);
            return ResponseUtil.ok(farms);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseUtil.notFound("해당 작물을 재배하는 농장이 없습니다.");
        } catch (Exception e) {
            return ResponseUtil.serverError("농장 목록 조회 중 오류가 발생했습니다.");
        }
    }

    // 농장 예약 신청
    @PostMapping("/apply")
    public ResponseEntity<?> applyForProgram(@RequestBody CustomerInfoDto customerDto, Authentication authentication) {
        try {
            CustomerInfoDto appliedCustomer = farmService.applyForProgram(customerDto, authentication.getName());
            return ResponseUtil.created("농장 예약 신청이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseUtil.serverError("농장 예약이 실패하였습니다.");
        }
    }

    // 예약 신청 승인 (농장주용)
    @PostMapping("/approve/{customerId}")
    public ResponseEntity<?> approve(@PathVariable Long customerId, Authentication authentication) {
        try {
            CustomerInfoDto updatedCustomer = farmService.updateStatus(customerId, "예약이 승인되었습니다. 이용해 주셔서 감사합니다!", authentication.getName());
            return ResponseUtil.ok(updatedCustomer);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseUtil.serverError("예약 승인 중 오류가 발생했습니다.");
        }
    }

    // 예약 신청 거절 (농장주용)
    @PostMapping("/reject/{customerId}")
    public ResponseEntity<?> reject(@PathVariable Long customerId, Authentication authentication) {
        try {
            CustomerInfoDto updatedCustomer = farmService.updateStatus(customerId, "죄송합니다. 해당 날짜에는 예약이 불가능합니다.", authentication.getName());
            return ResponseUtil.ok(updatedCustomer);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseUtil.serverError("예약 거절 중 오류가 발생했습니다.");
        }
    }

    // 농장 정보 생성 (농장주용)
    @PostMapping("/farminfo")
    public ResponseEntity<?> createFarmInfo(@RequestBody FarmInfoDto farmInfoDto, Authentication authentication) {
        try {
            FarmInfoDto createdFarm = farmService.createFarmInfo(farmInfoDto, authentication.getName());
            return ResponseUtil.created("농장 정보가 성공적으로 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseUtil.serverError("농장 정보 등록 중 오류가 발생했습니다.");
        }
    }
}