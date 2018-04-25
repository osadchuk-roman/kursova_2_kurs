package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfSportBuilding;
import osadchuk.roman.service.sportBuilding.impls.SportBuildingService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportBuildingController {
    @Autowired
    SportBuildingService sportBuildingService;

    @RequestMapping("/sport_building")
    public List<SportBuilding> show() throws SQLException {
        return sportBuildingService.getAll();
    }

    @RequestMapping("/sport_building/del")
    public SportBuilding del(@RequestParam int id) throws SQLException {
        return sportBuildingService.deleteSportBuilding(id);
    }

    @RequestMapping("/sport_building/insert")
    public SportBuilding insert(@RequestParam String name, int typeOfSportBuildingId,
                                String phone, String address) throws SQLException {
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(typeOfSportBuildingId,null);
        SportBuilding sportBuilding = new SportBuilding(
                0,
                name,
                typeOfSportBuilding,
                phone,
                address
        );
        return sportBuildingService.insertSportBuilding(sportBuilding);
    }

    @RequestMapping("/sport_building/update")
    public SportBuilding update(@RequestParam int id, String name, int typeOfSportBuildingId,
                                String phone, String address) throws SQLException {
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(typeOfSportBuildingId,null);
        SportBuilding sportBuilding = new SportBuilding(
                id,
                name,
                typeOfSportBuilding,
                phone,
                address
        );
        return sportBuildingService.updateSportBuilding(sportBuilding);
    }
}
