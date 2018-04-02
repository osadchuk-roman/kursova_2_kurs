package osadchuk.roman.model;

public class Stadium {
    public int id;
    public SportBuilding sportBuilding;
    public int capacity;
    public double fieldArea;
    public boolean presenceOfPathForRunning;
    public boolean presenceOfGymnasticZone;

    public Stadium() {
    }

    public Stadium(int id, SportBuilding sportBuilding, int capacity, double fieldArea,
                   boolean presenceOfPathForRunning, boolean presenceOfGymnasticZone) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.capacity = capacity;
        this.fieldArea = fieldArea;
        this.presenceOfPathForRunning = presenceOfPathForRunning;
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
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

    public boolean isPresenceOfPathForRunning() {
        return presenceOfPathForRunning;
    }

    public void setPresenceOfPathForRunning(boolean presenceOfPathForRunning) {
        this.presenceOfPathForRunning = presenceOfPathForRunning;
    }

    public boolean isPresenceOfGymnasticZone() {
        return presenceOfGymnasticZone;
    }

    public void setPresenceOfGymnasticZone(boolean presenceOfGymnasticZone) {
        this.presenceOfGymnasticZone = presenceOfGymnasticZone;
    }
}
