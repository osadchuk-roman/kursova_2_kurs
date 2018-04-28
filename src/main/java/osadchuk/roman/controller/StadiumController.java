package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.service.stadium.impls.StadiumService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StadiumController {
    @Autowired
    StadiumService stadiumService;
    @RequestMapping("/stadium")
    public List<Stadium> show() throws SQLException {
        return stadiumService.getAll();
    }

    @RequestMapping("/stadium/del")
    public Stadium del(@RequestParam int id) throws SQLException {
        return stadiumService.deleteStadium(id);
    }

    @RequestMapping("/stadium/insert")
    public Stadium insert(@RequestParam int sportBuildingId,int capacity,double fieldArea,
                      boolean pathForRunning, boolean gymnasticZone) throws SQLException {

        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        Stadium stadium=new Stadium(0,sportBuilding,capacity,fieldArea,pathForRunning,gymnasticZone);
        return stadiumService.insertStadium(stadium);
    }

    @RequestMapping("/stadium/update")
    public Stadium update(@RequestParam int id, int sportBuildingId,int capacity,double fieldArea,
                          boolean pathForRunning, boolean gymnasticZone) throws SQLException {
        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        Stadium stadium=new Stadium(id,sportBuilding,capacity,fieldArea,pathForRunning,gymnasticZone);
        return stadiumService.updateStadium(stadium);
    }
}
