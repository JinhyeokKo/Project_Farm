package farm.program.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "farm_crops")
public class FarmCrops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String crops;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private FarmInfo farmInfo;

    // Constructors
    public FarmCrops() {}

    public FarmCrops(String crops, FarmInfo farmInfo) {
        this.crops = crops;
        this.farmInfo = farmInfo;
    }

    // Getters and Setters
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

    public FarmInfo getFarmInfo() {
        return farmInfo;
    }

    public void setFarmInfo(FarmInfo farmInfo) {
        this.farmInfo = farmInfo;
    }
}