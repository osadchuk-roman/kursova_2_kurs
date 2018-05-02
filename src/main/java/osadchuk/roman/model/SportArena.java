package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "sport_arena")
@EntityListeners(AuditingEntityListener.class)
public class SportArena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    public SportBuilding sportBuilding;
    public int capacity;
    public Boolean presenceOfGymnasticZone;
    public Boolean presenceOfBoxingRing;
    public Boolean presenceOfMatirialArtsZone;

    public SportArena() {
    }

    public SportArena(SportBuilding sportBuilding, int capacity, boolean presenceOfGymnasticZone,
                      boolean presenceOfBoxingRing, boolean presenceOfMatirialArtsZone) {
        this.sportBuilding = sportBuilding;
        this.capacity = capacity;
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
        this.presenceOfBoxingRing = presenceOfBoxingRing;
        this.presenceOfMatirialArtsZone = presenceOfMatirialArtsZone;
    }
    /*public SportArena(int id, SportBuilding sportBuilding, int capacity,boolean presenceOfGymnasticZone,
                      boolean presenceOfBoxingRing, boolean presenceOfMatirialArtsZone) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.capacity = capacity;
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
        this.presenceOfBoxingRing = presenceOfBoxingRing;
        this.presenceOfMatirialArtsZone = presenceOfMatirialArtsZone;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean getPresenceOfGymnasticZone() {
        return presenceOfGymnasticZone;
    }

    public void setPresenceOfGymnasticZone(boolean presenceOfGymnasticZone) {
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
    }

    public boolean getPresenceOfBoxingRing() {
        return presenceOfBoxingRing;
    }

    public void setPresenceOfBoxingRing(boolean presenceOfBoxingRing) {
        this.presenceOfBoxingRing = presenceOfBoxingRing;
    }

    public boolean getPresenceOfMatirialArtsZone() {
        return presenceOfMatirialArtsZone;
    }

    public void setPresenceOfMatirialArtsZone(boolean presenceOfMatirialArtsZone) {
        this.presenceOfMatirialArtsZone = presenceOfMatirialArtsZone;
    }
}
