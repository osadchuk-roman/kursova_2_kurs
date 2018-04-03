package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.service.organizer.impls.OrganizerService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizerController {
    @Autowired
    OrganizerService organizerService;
    @RequestMapping("/organizer")
    public List<Organizer> showKindsOfSport() throws SQLException {
        return organizerService.getAll();
    }
}