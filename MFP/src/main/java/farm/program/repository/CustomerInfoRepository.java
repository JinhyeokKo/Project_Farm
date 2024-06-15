package farm.program.repository;

import farm.member.domain.Role;
import farm.program.domain.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
    @Query("SELECT fi FROM FarmInfo fi JOIN fi.member m WHERE m.role = :role")
    List<CustomerInfo> findByMemberRole(@Param("role") Role role);
}