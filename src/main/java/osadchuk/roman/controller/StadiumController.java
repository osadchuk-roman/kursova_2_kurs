package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.service.stadium.impls.StadiumService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StadiumController {
    @Autowired
    StadiumService stadiumService;
    @RequestMapping("/stadium")
    public List<Stadium> showKindsOfSport() throws SQLException {
        return stadiumService.getAll();
    }
}
