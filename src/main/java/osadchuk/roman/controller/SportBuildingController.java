package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.sportBuilding.impls.SportBuildingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportBuildingController {
    @Autowired
    SportBuildingService sportBuildingService;

    @RequestMapping("/sport_building")
    public List<SportBuilding> showKindsOfSport(){
        return sportBuildingService.getAll();
    }
}
