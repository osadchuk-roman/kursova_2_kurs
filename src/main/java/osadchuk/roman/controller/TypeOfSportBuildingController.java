package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.TypeOfSportBuilding;
import osadchuk.roman.service.typeOfSportBuilding.impls.TypeOfSportBuildingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfSportBuildingController {
    @Autowired
    TypeOfSportBuildingService typeOfSportBuildingService;

    @RequestMapping("/type_of_sport_building")
    public List<TypeOfSportBuilding> showTypesOfSportBuilding(){
        return typeOfSportBuildingService.getAll();
    }
}
