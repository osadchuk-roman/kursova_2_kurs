package osadchuk.roman.model;

public class Court {
    public int id;
    public SportBuilding sportBuilding;
    public TypeOfCover typeOfCover;
    public double width;
    public double length;

    public Court(int id, SportBuilding sportBuilding, TypeOfCover typeOfCover, double width, double length) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.typeOfCover = typeOfCover;
        this.width = width;
        this.length = length;
    }

    public Court() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SportBuilding getSportBuilding() {
        return sportBuilding;
    }

    public void setSportBuilding(SportBuilding sportBuilding) {
        this.sportBuilding = sportBuilding;
    }

    public TypeOfCover getTypeOfCover() {
        return typeOfCover;
    }

    public void setTypeOfCover(TypeOfCover typeOfCover) {
        this.typeOfCover = typeOfCover;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
