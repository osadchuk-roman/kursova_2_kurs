package osadchuk.roman.model;

public class SportClub {
    public int id;
    public String name;
    public String adminName;
    public String phone;
    public String address;

    public SportClub() {
    }

    public SportClub(int id, String name, String adminName, String phone, String address) {
        this.id = id;
        this.name = name;
        this.adminName = adminName;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
}
