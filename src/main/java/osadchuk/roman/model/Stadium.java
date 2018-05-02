package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "stadium")
@EntityListeners(AuditingEntityListener.class)
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    public SportBuilding sportBuilding;
    public int capacity;
    public double fieldArea;
    public Boolean presenceOfPathForRunning;
    public Boolean presenceOfGymnasticZone;

    public Stadium() {
    }

    public Stadium(SportBuilding sportBuilding, int capacity, double fieldArea,
                   boolean presenceOfPathForRunning, boolean presenceOfGymnasticZone) {
        this.sportBuilding = sportBuilding;
        this.capacity = capacity;
        this.fieldArea = fieldArea;
        this.presenceOfPathForRunning = presenceOfPathForRunning;
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
    }
/*public Stadium(int id, SportBuilding sportBuilding, int capacity, double fieldArea,
                   boolean presenceOfPathForRunning, boolean presenceOfGymnasticZone) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.capacity = capacity;
        this.fieldArea = fieldArea;
        this.presenceOfPathForRunning = presenceOfPathForRunning;
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
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

    public double getFieldArea() {
        return fieldArea;
    }

    public void setFieldArea(double fieldArea) {
        this.fieldArea = fieldArea;
    }

    public boolean getPresenceOfPathForRunning() {
        return presenceOfPathForRunning;
    }

    public void setPresenceOfPathForRunning(boolean presenceOfPathForRunning) {
        this.presenceOfPathForRunning = presenceOfPathForRunning;
    }

    public boolean getPresenceOfGymnasticZone() {
        return presenceOfGymnasticZone;
    }

    public void setPresenceOfGymnasticZone(boolean presenceOfGymnasticZone) {
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
    }
}
