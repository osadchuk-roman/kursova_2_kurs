package osadchuk.roman.model;

public class Gym {
    public int id;
    public SportBuilding sportBuilding;
    public boolean presenceOfCardioZone;
    public boolean presenceOfCrossfitZone;
    public boolean presenceOfBoxingRing;

    public Gym() {
    }

    public Gym(int id, SportBuilding sportBuilding, boolean presenceOfCardioZone,
               boolean presenceOfCrossfitZone, boolean presenceOfBoxingRing) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.presenceOfCardioZone = presenceOfCardioZone;
        this.presenceOfCrossfitZone = presenceOfCrossfitZone;
        this.presenceOfBoxingRing = presenceOfBoxingRing;
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

    public boolean isPresenceOfCardioZone() {
        return presenceOfCardioZone;
    }

    public void setPresenceOfCardioZone(boolean presenceOfCardioZone) {
        this.presenceOfCardioZone = presenceOfCardioZone;
    }

    public boolean isPresenceOfCrossfitZone() {
        return presenceOfCrossfitZone;
    }

    public void setPresenceOfCrossfitZone(boolean presenceOfCrossfitZone) {
        this.presenceOfCrossfitZone = presenceOfCrossfitZone;
    }

    public boolean isPresenceOfBoxingRing() {
        return presenceOfBoxingRing;
    }

    public void setPresenceOfBoxingRing(boolean presenceOfBoxingRing) {
        this.presenceOfBoxingRing = presenceOfBoxingRing;
    }
}
