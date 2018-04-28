package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Gym;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.gym.impls.GymService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GymController {
    @Autowired
    GymService gymService;
    @RequestMapping("/gym")
    public List<Gym> show() throws SQLException {
        return gymService.getAll();
    }

    @RequestMapping("/gym/del")
    public Gym del(@RequestParam int id) throws SQLException {
        return gymService.deleteGym(id);
    }

    @RequestMapping("/gym/insert")
    public Gym insert(@RequestParam int sportBuildingId,boolean cardioZone,
                      boolean crossfitZone, boolean boxingRing) throws SQLException {

        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        Gym gym=new Gym(0,sportBuilding,cardioZone,crossfitZone,boxingRing);
        return gymService.insertGym(gym);
    }

    @RequestMapping("/gym/update")
    public Gym update(@RequestParam int id, int sportBuildingId, boolean cardioZone,
                      boolean crossfitZone, boolean boxingRing) throws SQLException {
        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        Gym gym=new Gym(id,sportBuilding,cardioZone,crossfitZone,boxingRing);
        return gymService.updateGym(gym);
    }
}
