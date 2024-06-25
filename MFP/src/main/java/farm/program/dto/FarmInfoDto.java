package farm.program.dto;

import farm.program.domain.FarmInfo;

import java.util.List;
import java.util.stream.Collectors;

public class FarmInfoDto {
    private Long id;
    private String name;
    private String address;
    private List<String> crops;

    // 기본 생성자
    public FarmInfoDto() {}

    // 엔티티를 DTO로 변환하는 변환 생성자
    public FarmInfoDto(FarmInfo entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.crops = entity.getFarmCrops().stream()
                .map(farmCrop -> farmCrop.getCrops())
                .collect(Collectors.toList());
    }

    // 엔티티를 DTO로 변환하는 정적 메서드
    public static FarmInfoDto fromEntity(FarmInfo entity) {
        return new FarmInfoDto(entity);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCrops() {
        return crops;
    }

    public void setCrops(List<String> crops) {
        this.crops = crops;
    }
}