package farm.program.repository;

import farm.program.domain.FarmCrops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmCropsRepository extends JpaRepository<FarmCrops, Long> {
    @Query("SELECT DISTINCT fc.crops FROM FarmCrops fc")
    List<String> findDistinctCrops();
}