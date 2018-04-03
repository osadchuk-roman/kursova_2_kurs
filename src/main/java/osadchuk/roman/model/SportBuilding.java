package osadchuk.roman.model;

public class SportBuilding {
    public int id;
    public String name;
    public TypeOfSportBuilding typeOfSportBuilding;
    public String phone;
    public String address;

    public SportBuilding() {
    }

    public SportBuilding(int id, String name, TypeOfSportBuilding typeOfSportBuilding, String phone, String address) {
        this.id = id;
        this.name = name;
        this.typeOfSportBuilding = typeOfSportBuilding;
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
