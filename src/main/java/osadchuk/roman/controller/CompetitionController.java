package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Competition;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.competition.impls.CompetitionService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompetitionController {
    @Autowired
    CompetitionService competitionService;
    @RequestMapping("/competition")
    public List<Competition> getAll() throws SQLException {
        return competitionService.getAll();
    }

    @RequestMapping("/competition/del")
    public Competition delete(@RequestParam int id) throws SQLException {
        return competitionService.deleteCompetition(id);
    }

    @RequestMapping("/competition/insert")
    public Competition insert(@RequestParam String name, Date date, int organizerId,
                              int sportBuildingId, int sportId) throws SQLException {
        Organizer organizer = new Organizer(organizerId,null,null,null,null);
        SportBuilding sportBuilding= new SportBuilding(sportBuildingId,null,
                null,null,null);
        KindOfSport kindOfSport =new KindOfSport(sportId,null);
        Competition competition=new Competition(0, name, date, organizer,sportBuilding,kindOfSport);
        return competitionService.insertCompetition(competition);
    }

    @RequestMapping("/competition/update")
    public Competition insert(@RequestParam int id, String name, Date date, int organizerId,
                              int sportBuildingId, int sportId) throws SQLException {
        Organizer organizer = new Organizer(organizerId,null,null,null,null);
        SportBuilding sportBuilding= new SportBuilding(sportBuildingId,null,
                null,null,null);
        KindOfSport kindOfSport =new KindOfSport(sportId,null);
        Competition competition=new Competition(id, name, date, organizer,sportBuilding,kindOfSport);
        return competitionService.updateCompetition(competition);
    }
}
