package farm.program.dto;

import farm.program.domain.CustomerInfo;

public class CustomerInfoDto {
    private Long id;
    private String name;
    private String selectedCrop;
    private String status;
    private Long memberId;
    private Long farmId;

    // 기본 생성자
    public CustomerInfoDto() {}

    // 엔티티를 DTO로 변환하는 변환 생성자
    public CustomerInfoDto(CustomerInfo entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.selectedCrop = entity.getSelectedCrop();
        this.status = entity.getStatus();
        if (entity.getMember() != null) {
            this.memberId = entity.getMember().getId();
        }
        if (entity.getFarmInfo() != null) {
            this.farmId = entity.getFarmInfo().getId();
        }
    }

    // 엔티티를 DTO로 변환하는 정적 메서드
    public static CustomerInfoDto fromEntity(CustomerInfo entity) {
        return new CustomerInfoDto(entity);
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

    public String getSelectedCrop() {
        return selectedCrop;
    }

    public void setSelectedCrop(String selectedCrop) {
        this.selectedCrop = selectedCrop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }
}