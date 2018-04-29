package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Organizer> getAll() throws SQLException {
        return organizerService.getAll();
    }
    @RequestMapping("/organizer/del")
    public Organizer delete(@RequestParam int id) throws SQLException {
        return organizerService.deleteOrganizer(id);
    }

    @RequestMapping("/organizer/insert")
    public Organizer insert(@RequestParam String name, String adminName, String phone, String address) throws SQLException {
        Organizer organizer = new Organizer(0,name,adminName,phone,address);
        return organizerService.insertOrganizer(organizer);
    }

    @RequestMapping("/organizer/update")
    public Organizer insert(@RequestParam int id, String name, String adminName, String phone, String address) throws SQLException {
        Organizer organizer = new Organizer(id,name,adminName,phone,address);
        return organizerService.updateOrganizer(organizer);
    }
}
