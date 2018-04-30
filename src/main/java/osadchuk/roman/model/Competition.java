package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "competition")
@EntityListeners(AuditingEntityListener.class)
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public Date date;
    @ManyToOne
    public Organizer organizer;
    @ManyToOne
    public SportBuilding sportBuilding;
    @ManyToOne
    public KindOfSport kindOfSport;

    public Competition() {
    }

    public Competition(String name, Date date, Organizer organizer, SportBuilding sportBuilding,
                       KindOfSport kindOfSport) {
        this.name = name;
        this.date = date;
        this.organizer = organizer;
        this.sportBuilding = sportBuilding;
        this.kindOfSport = kindOfSport;
    }
    /*public Competition(int id, String name, Date date, Organizer organizer, SportBuilding sportBuilding, KindOfSport kindOfSport) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.organizer = organizer;
        this.sportBuilding = sportBuilding;
        this.kindOfSport = kindOfSport;
    }*/

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
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
