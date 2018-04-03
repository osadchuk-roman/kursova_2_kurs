package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Court;
import osadchuk.roman.service.court.impls.CourtService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourtController {
    @Autowired
    CourtService courtService;
    @RequestMapping("/court")
    public List<Court> showKindsOfSport() throws SQLException {
        return courtService.getAll();
    }
}
