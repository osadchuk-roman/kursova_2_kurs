package osadchuk.roman.model;

public class SportsmanSportCoach {
    public int id;
    public Sportsman sportsman;
    public KindOfSport kindOfSport;
    public SportCategory sportCategory;
    public Coach coach;

    public SportsmanSportCoach() {
    }

    public SportsmanSportCoach(int id, Sportsman sportsman, KindOfSport kindOfSport, SportCategory sportCategory, Coach coach) {
        this.id = id;
        this.sportsman = sportsman;
        this.kindOfSport = kindOfSport;
        this.sportCategory = sportCategory;
        this.coach = coach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    public KindOfSport getKindOfSport() {
        return kindOfSport;
    }

    public void setKindOfSport(KindOfSport kindOfSport) {
        this.kindOfSport = kindOfSport;
    }

    public SportCategory getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(SportCategory sportCategory) {
        this.sportCategory = sportCategory;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
