package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportsmanCompetition;
import osadchuk.roman.service.sportsmanCompetition.impls.SportsmanCompetitionService;

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
}
