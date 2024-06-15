package farm.program.repository;

import farm.program.domain.Crops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropsRepository extends JpaRepository<Crops, Long> {
}
