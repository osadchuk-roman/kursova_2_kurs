package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.service.sportsman.impls.SportsmanService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanController {
    @Autowired
    SportsmanService sportsmanService;
    @RequestMapping("/sportsman")
    public List<Sportsman> show() throws SQLException {
        return sportsmanService.getAll();
    }


    @RequestMapping("/sportsman/del")
    public Sportsman del(@RequestParam int id) throws SQLException {
        return sportsmanService.deleteSportsman(id);
    }

    @RequestMapping("/sportsman/getById")
    public Sportsman getById(@RequestParam int id) throws SQLException {
        return sportsmanService.getSportsman(id);
    }

    @RequestMapping("/sportsman/insert")
    public Sportsman insert(@RequestParam String name,int age,String gender,int sportClubId) throws SQLException {
        SportClub sportClub = new SportClub(sportClubId,null,null,null,null);
        Sportsman sportBuilding = new Sportsman(
                0,
                name,
                age,
                gender,
                sportClub
        );
        return sportsmanService.insertSportsman(sportBuilding);
    }

    @RequestMapping("/sportsman/update")
    public Sportsman update(@RequestParam int id, String name,int age,String gender,int sportClubId) throws SQLException {
        SportClub sportClub = new SportClub(sportClubId,null,null,null,null);
        Sportsman sportBuilding = new Sportsman(
                id,
                name,
                age,
                gender,
                sportClub
        );
        return sportsmanService.updateSportsman(sportBuilding);
    }
}
