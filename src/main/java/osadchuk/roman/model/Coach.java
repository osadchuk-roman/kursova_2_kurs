package osadchuk.roman.model;

public class Coach {
    public int id;
    public String name;
    SportClub sportClub;

    public Coach(int i, Sportsman sportsman, KindOfSport kindOfSport, SportCategory sportCategory, Coach coach) {
    }

    public Coach(int id, String name, SportClub sportClub) {
        this.id = id;
        this.name = name;
        this.sportClub = sportClub;
    }

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

    public SportClub getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClub sportClub) {
        this.sportClub = sportClub;
    }
}
