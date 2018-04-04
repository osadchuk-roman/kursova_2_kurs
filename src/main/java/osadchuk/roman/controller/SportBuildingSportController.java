package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.service.sportBuildingSport.impls.SportBuildingSportService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportBuildingSportController {
    @Autowired
    SportBuildingSportService sportBuildingSportService;
    @RequestMapping("/sport_building_sport")
    public List<SportBuildingSport> showKindsOfSport() throws SQLException {
        return sportBuildingSportService.getAll();
    }
}
