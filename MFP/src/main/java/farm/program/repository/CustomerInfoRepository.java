package farm.program.repository;

import farm.program.domain.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
    List<CustomerInfo> findByFarmInfoId(Long farmId);
    List<CustomerInfo> findByMemberId(Long memberId);
}