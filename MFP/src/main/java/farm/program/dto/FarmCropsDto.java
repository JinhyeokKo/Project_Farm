package farm.program.dto;

import farm.program.domain.FarmCrops;

public class FarmCropsDto {
    private Long id;
    private String crops;
    private Long farmId;

    // 기본 생성자
    public FarmCropsDto() {}

    // 엔티티를 DTO로 변환하는 변환 생성자
    public FarmCropsDto(FarmCrops entity) {
        this.id = entity.getId();
        this.crops = entity.getCrops();
        if (entity.getFarmInfo() != null) {
            this.farmId = entity.getFarmInfo().getId();
        }
    }

    // 엔티티를 DTO로 변환하는 정적 메서드
    public static FarmCropsDto fromEntity(FarmCrops entity) {
        return new FarmCropsDto(entity);
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

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }
}