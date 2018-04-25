package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.service.sportClub.impls.SportClubService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportClubController {
    @Autowired
    SportClubService sportClubService;
    @RequestMapping("/sport_club")
    public List<SportClub> show() throws SQLException {
        return sportClubService.getAll();
    }
    @RequestMapping("/sport_club/del")
    public SportClub delete(@RequestParam int id) throws SQLException {
        return sportClubService.deleteSportClub(id);
    }

    @RequestMapping("/sport_club/insert")
    public SportClub insert(@RequestParam String name, String adminName, String phone, String address) throws SQLException {
        SportClub sportClub = new SportClub(0,name,adminName,phone,address);
        return sportClubService.insertSportClub(sportClub);
    }

    @RequestMapping("/sport_club/update")
    public SportClub insert(@RequestParam int id, String name, String adminName, String phone, String address) throws SQLException {
        SportClub sportClub = new SportClub(id,name,adminName,phone,address);
        return sportClubService.updateSportClub(sportClub);
    }
}
