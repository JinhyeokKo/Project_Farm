package farm.member.dto;

import farm.member.domain.Member;

public class MemberDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private byte[] profileImage;

    private MemberDto() {
    }

    private MemberDto(Member member) {
        this.username = member.getUsername();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.email = member.getEmail();
        this.profileImage = member.getProfileImage();
    }

    public static MemberDto createMemberDto(Member member) {
        return new MemberDto(member);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }
}
