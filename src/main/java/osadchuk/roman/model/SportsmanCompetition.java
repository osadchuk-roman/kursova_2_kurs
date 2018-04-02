package osadchuk.roman.model;

public class SportsmanCompetition {
    public int id;
    public Sportsman sportsman;
    public Competition competition;
    public int prizePlace;

    public SportsmanCompetition() {
    }

    public SportsmanCompetition(int id, Sportsman sportsman, Competition competition, int prizePlace) {
        this.id = id;
        this.sportsman = sportsman;
        this.competition = competition;
        this.prizePlace = prizePlace;
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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public int getPrizePlace() {
        return prizePlace;
    }

    public void setPrizePlace(int prizePlace) {
        this.prizePlace = prizePlace;
    }
}
