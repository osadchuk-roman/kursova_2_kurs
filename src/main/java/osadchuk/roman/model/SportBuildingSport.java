package osadchuk.roman.model;

public class SportBuildingSport {
    public int id;
    public SportBuilding sportBuilding;
    public KindOfSport kindOfSport;

    public SportBuildingSport() {
    }

    public SportBuildingSport(int id, SportBuilding sportBuilding, KindOfSport kindOfSport) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.kindOfSport = kindOfSport;
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

    public KindOfSport getKindOfSport() {
        return kindOfSport;
    }

    public void setKindOfSport(KindOfSport kindOfSport) {
        this.kindOfSport = kindOfSport;
    }
}
