package farm.program.domain;

import farm.member.domain.Member;
import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "farmInfos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FarmCrop> farmCrops;

    @ManyToOne
    @JoinColumn(name = "member_role")
    private Member member;

    @OneToMany(mappedBy = "farmInfos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerInfo> customerInfos;

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
}