package farm.program.repository;

import farm.program.domain.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
}