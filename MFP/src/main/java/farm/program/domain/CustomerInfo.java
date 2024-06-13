package farm.program.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String selectedCrop;
    private Long selectedFarmId;
    private String status;

    // Getters and setters
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

    public Long getSelectedFarmId() {
        return selectedFarmId;
    }

    public void setSelectedFarmId(Long selectedFarmId) {
        this.selectedFarmId = selectedFarmId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}