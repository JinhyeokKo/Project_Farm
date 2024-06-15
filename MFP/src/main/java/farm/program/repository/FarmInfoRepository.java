package farm.program.repository;

import farm.member.domain.Role;
import farm.program.domain.FarmInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FarmInfoRepository extends JpaRepository<FarmInfo, Long> {
    FarmInfo findByName(String farmName);
    @Query("SELECT fi FROM FarmInfo fi JOIN fi.member m WHERE m.role = :role")
    List<FarmInfo> findByMemberRole(@Param("role") Role role);


}