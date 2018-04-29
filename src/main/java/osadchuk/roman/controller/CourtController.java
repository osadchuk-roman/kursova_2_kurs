package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Court;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.service.court.impls.CourtService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourtController {
    @Autowired
    CourtService courtService;
    @RequestMapping("/court")
    public List<Court> getAll() throws SQLException {
        return courtService.getAll();
    }

    @RequestMapping("/court/del")
    public Court del(@RequestParam int id) throws SQLException {
        return courtService.deleteCourt(id);
    }

    @RequestMapping("/court/insert")
    public Court insert(@RequestParam int sportBuildingId,int typeOfCoverId,
                        double width, double length) throws SQLException {

        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        TypeOfCover typeOfCover= new TypeOfCover(typeOfCoverId,null);
        Court court=new Court(0,sportBuilding,typeOfCover,width,length);
        return courtService.insertCourt(court);
    }

    @RequestMapping("/court/update")
    public Court update(@RequestParam int id, int sportBuildingId,int typeOfCoverId,
                       double width, double length) throws SQLException {
        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        TypeOfCover typeOfCover= new TypeOfCover(typeOfCoverId,null);
        Court court=new Court(id,sportBuilding,typeOfCover,width,length);
        return courtService.updateCourt(court);
    }
}
