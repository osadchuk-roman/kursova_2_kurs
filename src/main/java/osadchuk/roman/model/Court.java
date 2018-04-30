package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "court")
@EntityListeners(AuditingEntityListener.class)
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    public SportBuilding sportBuilding;
    @ManyToOne
    public TypeOfCover typeOfCover;
    public double width;
    public double length;

    public Court(SportBuilding sportBuilding, TypeOfCover typeOfCover, double width, double length) {
        this.sportBuilding = sportBuilding;
        this.typeOfCover = typeOfCover;
        this.width = width;
        this.length = length;
    }

    /*public Court(int id, SportBuilding sportBuilding, TypeOfCover typeOfCover, double width, double length) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.typeOfCover = typeOfCover;
        this.width = width;
        this.length = length;
    }*/

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
