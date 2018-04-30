package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "sportsman_competition")
@EntityListeners(AuditingEntityListener.class)
public class SportsmanCompetition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    public Sportsman sportsman;
    @ManyToOne
    public Competition competition;
    public int prizePlace;

    public SportsmanCompetition() {
    }

    public SportsmanCompetition(Sportsman sportsman, Competition competition, int prizePlace) {
        this.sportsman = sportsman;
        this.competition = competition;
        this.prizePlace = prizePlace;
    }
    /*public SportsmanCompetition(int id, Sportsman sportsman, Competition competition, int prizePlace) {
        this.id = id;
        this.sportsman = sportsman;
        this.competition = competition;
        this.prizePlace = prizePlace;
    }*/

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
