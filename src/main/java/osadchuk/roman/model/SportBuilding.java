package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "sport_building")
@EntityListeners(AuditingEntityListener.class)
public class SportBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    @ManyToOne
    public TypeOfSportBuilding typeOfSportBuilding;
    public String phone;
    public String address;

    public SportBuilding() {
    }

    public SportBuilding(String name, TypeOfSportBuilding typeOfSportBuilding, String phone, String address) {
        this.name = name;
        this.typeOfSportBuilding = typeOfSportBuilding;
        this.phone = phone;
        this.address = address;
    }
    /* public SportBuilding(int id, String name, TypeOfSportBuilding typeOfSportBuilding, String phone, String address) {
        this.id = id;
        this.name = name;
        this.typeOfSportBuilding = typeOfSportBuilding;
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

    public TypeOfSportBuilding getTypeOfSportBuilding() {
        return typeOfSportBuilding;
    }

    public void setTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) {
        this.typeOfSportBuilding = typeOfSportBuilding;
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
