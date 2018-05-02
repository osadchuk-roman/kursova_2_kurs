package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "gym")
@EntityListeners(AuditingEntityListener.class)
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    public SportBuilding sportBuilding;
    public Boolean presenceOfCardioZone;
    public Boolean presenceOfCrossfitZone;
    public Boolean presenceOfBoxingRing;

    public Gym() {
    }

    public Gym(SportBuilding sportBuilding, boolean presenceOfCardioZone,
               boolean presenceOfCrossfitZone, boolean presenceOfBoxingRing) {
        this.sportBuilding = sportBuilding;
        this.presenceOfCardioZone = presenceOfCardioZone;
        this.presenceOfCrossfitZone = presenceOfCrossfitZone;
        this.presenceOfBoxingRing = presenceOfBoxingRing;
    }

    /*public Gym(int id, SportBuilding sportBuilding, boolean presenceOfCardioZone,
               boolean presenceOfCrossfitZone, boolean presenceOfBoxingRing) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.presenceOfCardioZone = presenceOfCardioZone;
        this.presenceOfCrossfitZone = presenceOfCrossfitZone;
        this.presenceOfBoxingRing = presenceOfBoxingRing;
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

    public boolean getPresenceOfCardioZone() {
        return presenceOfCardioZone;
    }

    public void setPresenceOfCardioZone(boolean presenceOfCardioZone) {
        this.presenceOfCardioZone = presenceOfCardioZone;
    }

    public boolean getPresenceOfCrossfitZone() {
        return presenceOfCrossfitZone;
    }

    public void setPresenceOfCrossfitZone(boolean presenceOfCrossfitZone) {
        this.presenceOfCrossfitZone = presenceOfCrossfitZone;
    }

    public boolean getPresenceOfBoxingRing() {
        return presenceOfBoxingRing;
    }

    public void setPresenceOfBoxingRing(boolean presenceOfBoxingRing) {
        this.presenceOfBoxingRing = presenceOfBoxingRing;
    }
}
