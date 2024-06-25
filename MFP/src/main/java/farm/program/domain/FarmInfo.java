package farm.program.domain;

import farm.member.domain.Member;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "farm_infos")
public class FarmInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "farm_id")
    private Long id;

    @Column(name = "farm_name")
    private String name;

    private String address;

    @OneToMany(mappedBy = "farmInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FarmCrops> farmCrops = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "farmInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerInfo> customerInfos = new ArrayList<>();

    // Constructors
    public FarmInfo() {}

    public FarmInfo(String name, String address, Member member) {
        this.name = name;
        this.address = address;
        this.member = member;
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

    public List<FarmCrops> getFarmCrops() {
        return farmCrops;
    }

    public void setFarmCrops(List<FarmCrops> farmCrops) {
        this.farmCrops = farmCrops;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<CustomerInfo> getCustomerInfos() {
        return customerInfos;
    }

    public void setCustomerInfos(List<CustomerInfo> customerInfos) {
        this.customerInfos = customerInfos;
    }

    // 편의 메서드
    public void addFarmCrop(FarmCrops farmCrop) {
        farmCrops.add(farmCrop);
        farmCrop.setFarmInfo(this);
    }

    public void removeFarmCrop(FarmCrops farmCrop) {
        farmCrops.remove(farmCrop);
        farmCrop.setFarmInfo(null);
    }

    public void addCustomerInfo(CustomerInfo customerInfo) {
        customerInfos.add(customerInfo);
        customerInfo.setFarmInfo(this);
    }

    public void removeCustomerInfo(CustomerInfo customerInfo) {
        customerInfos.remove(customerInfo);
        customerInfo.setFarmInfo(null);
    }
}