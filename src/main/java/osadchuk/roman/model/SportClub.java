package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "sport_club")
@EntityListeners(AuditingEntityListener.class)
public class SportClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "admin_name")
    public String adminName;

    @Column(name = "phone")
    public String phone;

    @Column(name = "address")
    public String address;

    public SportClub(String name, String adminName, String phone, String address) {
        this.name = name;
        this.adminName = adminName;
        this.phone = phone;
        this.address = address;
    }

    public SportClub() {
    }

    /*public SportClub(int id, String name, String adminName, String phone, String address) {
        this.id = id;
        this.name = name;
        this.adminName = adminName;
        this.phone = phone;
        this.address = address;
    }*/

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
