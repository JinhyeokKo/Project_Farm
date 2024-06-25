package farm.program.repository;

import farm.program.domain.FarmInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmInfoRepository extends JpaRepository<FarmInfo, Long> {
    @Query("SELECT DISTINCT f FROM FarmInfo f JOIN f.farmCrops fc WHERE fc.crops = :crop")
    List<FarmInfo> findByCrop(@Param("crop") String crop);

    List<FarmInfo> findByMemberId(Long memberId);
}