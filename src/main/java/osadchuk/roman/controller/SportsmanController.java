package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.service.sportsman.impls.SportsmanService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanController {
    @Autowired
    SportsmanService sportsmanService;
    @RequestMapping("/sportsman")
    public List<Sportsman> showKindsOfSport() throws SQLException {
        return sportsmanService.getAll();
    }
}
