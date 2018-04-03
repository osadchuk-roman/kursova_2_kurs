package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Coach;
import osadchuk.roman.service.coach.impls.CoachService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CoachController {
    @Autowired
    CoachService coachService;
    @RequestMapping("/coach")
    public List<Coach> showKindsOfSport() throws SQLException {
        return coachService.getAll();
    }
}
