package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.TypeOfSportBuilding;
import osadchuk.roman.service.typeOfSportBuilding.impls.TypeOfSportBuildingService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfSportBuildingController {
    @Autowired
    TypeOfSportBuildingService typeOfSportBuildingService;

    @RequestMapping("/type_of_sport_building")
    public List<TypeOfSportBuilding> showTypesOfSportBuilding() throws SQLException {
        return typeOfSportBuildingService.getAll();
    }

    @RequestMapping("/type_of_sport_building/del")
    public TypeOfSportBuilding deleteTypesOfSportBuilding(@RequestParam int id) throws SQLException {
        return typeOfSportBuildingService.deleteTypeOfSportBuilding(id);
    }

    @RequestMapping("/type_of_sport_building/insert")
    public TypeOfSportBuilding insert(@RequestParam String name) throws SQLException {
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(0,name);
        return typeOfSportBuildingService.insertTypeOfSportBuilding(typeOfSportBuilding);
    }

    @RequestMapping("/type_of_sport_building/update")
    public TypeOfSportBuilding insert(@RequestParam int id, String name) throws SQLException {
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(id,name);
        return typeOfSportBuildingService.updateTypeOfSportBuilding(typeOfSportBuilding);
    }
}
