package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Coach;
import osadchuk.roman.model.SportClub;
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

    @RequestMapping("/coach/del")
    public Coach delCoach(@RequestParam int id) throws SQLException {
        return coachService.deleteCoach(id);
    }

    @RequestMapping("/coach/getById")
    public Coach getById(@RequestParam int id) throws SQLException {
        return coachService.getCoach(id);
    }
    @RequestMapping("/coach/insert")
    public Coach insert(@RequestParam String name,int sportClubId) throws SQLException {
        SportClub sportClub = new SportClub(sportClubId,null,null,null,null);
        Coach sportBuilding = new Coach(
                0,
                name,
                sportClub
        );
        return coachService.insertCoach(sportBuilding);
    }

    @RequestMapping("/coach/update")
    public Coach update(@RequestParam int id, String name,int sportClubId) throws SQLException {
        SportClub sportClub = new SportClub(sportClubId,null,null,null,null);
        Coach sportBuilding = new Coach(
                id,
                name,
                sportClub
        );
        return coachService.updateCoach(sportBuilding);
    }
}
