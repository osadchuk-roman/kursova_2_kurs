package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.*;
import osadchuk.roman.service.sportsmanCompetition.impls.SportsmanCompetitionService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanCompetitionController {
    @Autowired
    SportsmanCompetitionService sportsmanCompetitionService;
    @RequestMapping("/sportsman_competition")
    public List<SportsmanCompetition> showKindsOfSport() throws SQLException {
        return sportsmanCompetitionService.getAll();
    }

    @RequestMapping("/sportsman_competition/del")
    public SportsmanCompetition delete(@RequestParam int id) throws SQLException {
        return sportsmanCompetitionService.deleteSportsmanCompetition(id);
    }

    @RequestMapping("/sportsman_competition/insert")
    public SportsmanCompetition insert(@RequestParam int sportsmanId, int competitionId,
                              int prizePlace) throws SQLException {

        Competition competition=new Competition(competitionId, null, null, null,
                                    null,null);
        Sportsman sportsman = new Sportsman(sportsmanId,null,0,null,null);
        SportsmanCompetition sportsmanCompetition = new SportsmanCompetition(
                0,sportsman,competition,prizePlace
        );
        return sportsmanCompetitionService.insertSportsmanCompetition(sportsmanCompetition);
    }

    @RequestMapping("/sportsman_competition/update")
    public SportsmanCompetition insert(@RequestParam int id, int sportsmanId, int competitionId,
                                       int prizePlace) throws SQLException {

        Competition competition=new Competition(competitionId, null, null, null,
                null,null);
        Sportsman sportsman = new Sportsman(sportsmanId,null,0,null,null);
        SportsmanCompetition sportsmanCompetition = new SportsmanCompetition(
                id,sportsman,competition,prizePlace
        );
        return sportsmanCompetitionService.updateSportsmanCompetition(sportsmanCompetition);
    }
}
