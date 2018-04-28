package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.SportBuilding;
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
    public List<SportBuildingSport> show() throws SQLException {
        return sportBuildingSportService.getAll();
    }

    @RequestMapping("/sport_building_sport/del")
    public SportBuildingSport del(@RequestParam int id) throws SQLException {
        return sportBuildingSportService.deleteSportBuildingSport(id);
    }

    @RequestMapping("/sport_building_sport/insert")
    public SportBuildingSport insert(@RequestParam  int sportBuildingId, int sportId) throws SQLException {

        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        KindOfSport kindOfSport= new KindOfSport(sportId,null);
        SportBuildingSport sportBuildingSport = new SportBuildingSport(
                0,
                sportBuilding,
                kindOfSport
        );
        return sportBuildingSportService.insertSportBuildingSport(sportBuildingSport);
    }

    @RequestMapping("/sport_building_sport/update")
    public SportBuildingSport update(@RequestParam int id, int sportBuildingId, int sportId) throws SQLException {
        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        KindOfSport kindOfSport= new KindOfSport(sportId,null);
        SportBuildingSport sportBuildingSport = new SportBuildingSport(
                id,
                sportBuilding,
                kindOfSport
        );
        return sportBuildingSportService.updateSportBuildingSport(sportBuildingSport);
    }
}
