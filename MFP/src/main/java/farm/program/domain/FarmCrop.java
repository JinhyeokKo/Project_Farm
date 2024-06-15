package farm.program.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "farm_crops")
public class FarmCrop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crops;

    @ManyToOne
    @JoinColumn(name = "farm_name")
    private FarmInfo farmInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrops() {
        return crops;
    }

    public void setCrops(String crops) {
        this.crops = crops;
    }

    public FarmInfo getFarmInfos() {
        return farmInfos;
    }

    public void setFarmInfos(FarmInfo farmInfos) {
        this.farmInfos = farmInfos;
    }
}
