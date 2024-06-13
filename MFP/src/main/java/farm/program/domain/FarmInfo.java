package farm.program.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FarmInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ElementCollection
    private List<String> crops;

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