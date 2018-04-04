package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Competition;
import osadchuk.roman.service.competition.impls.CompetitionService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompetitionController {
    @Autowired
    CompetitionService competitionService;
    @RequestMapping("/competition")
    public List<Competition> showKindsOfSport() throws SQLException {
        return competitionService.getAll();
    }
}
