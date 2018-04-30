package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "sport_building_sport")
@EntityListeners(AuditingEntityListener.class)
public class SportBuildingSport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    public SportBuilding sportBuilding;
    @ManyToOne
    public KindOfSport kindOfSport;

    public SportBuildingSport() {
    }

    public SportBuildingSport(SportBuilding sportBuilding, KindOfSport kindOfSport) {
        this.sportBuilding = sportBuilding;
        this.kindOfSport = kindOfSport;
    }
/*public SportBuildingSport(int id, SportBuilding sportBuilding, KindOfSport kindOfSport) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.kindOfSport = kindOfSport;
    }*/

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

    public KindOfSport getKindOfSport() {
        return kindOfSport;
    }

    public void setKindOfSport(KindOfSport kindOfSport) {
        this.kindOfSport = kindOfSport;
    }
}
