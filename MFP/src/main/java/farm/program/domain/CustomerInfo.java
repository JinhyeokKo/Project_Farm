package farm.program.domain;

import farm.member.domain.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_infos")
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String selectedCrop;
    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private FarmInfo farmInfo;

    // Constructors
    public CustomerInfo() {}

    public CustomerInfo(String name, String selectedCrop, String status, Member member, FarmInfo farmInfo) {
        this.name = name;
        this.selectedCrop = selectedCrop;
        this.status = status;
        this.member = member;
        this.farmInfo = farmInfo;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public FarmInfo getFarmInfo() {
        return farmInfo;
    }

    public void setFarmInfo(FarmInfo farmInfo) {
        this.farmInfo = farmInfo;
    }
}