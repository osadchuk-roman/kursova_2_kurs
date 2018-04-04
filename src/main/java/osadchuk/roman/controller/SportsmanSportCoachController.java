package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportsmanSportCoach;
import osadchuk.roman.service.sportsmanSportCoach.impls.SportsmanSportCoachService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanSportCoachController {
    @Autowired
    SportsmanSportCoachService sportsmanSportCoachService;
    @RequestMapping("/sportsman_sport_coach")
    public List<SportsmanSportCoach> showKindsOfSport() throws SQLException {
        return sportsmanSportCoachService.getAll();
    }
}
