package farm.program.repository;

import farm.program.domain.FarmInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmInfoRepository extends JpaRepository<FarmInfo, Long> {
    List<FarmInfo> findByCropsContaining(String crop);
}