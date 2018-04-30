package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "type_of_sport_building")
@EntityListeners(AuditingEntityListener.class)
public class TypeOfSportBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    public TypeOfSportBuilding() {
    }

    public TypeOfSportBuilding(String name) {
        this.name = name;
    }
    /*public TypeOfSportBuilding(int id, String name) {
        this.id = id;
        this.name = name;
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
}
