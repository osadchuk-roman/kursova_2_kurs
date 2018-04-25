package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.service.typeOfCover.impls.TypeOfCoverService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfCoverController {
    @Autowired
    TypeOfCoverService typeOfCoverService;

    @RequestMapping("/type_of_cover")
    public List<TypeOfCover> show() throws SQLException {
        return typeOfCoverService.getAll();
    }

    @RequestMapping("/type_of_cover/del")
    public TypeOfCover del(@RequestParam int id) throws SQLException {
        return typeOfCoverService.deleteTypeOfCover(id);
    }

    @RequestMapping("/type_of_cover/insert")
    public TypeOfCover insert(@RequestParam String name) throws SQLException {
        TypeOfCover typeOfSportBuilding = new TypeOfCover(0,name);
        return typeOfCoverService.insertTypeOfCover(typeOfSportBuilding);
    }

    @RequestMapping("/type_of_cover/update")
    public TypeOfCover insert(@RequestParam int id, String name) throws SQLException {
        TypeOfCover typeOfSportBuilding = new TypeOfCover(id,name);
        return typeOfCoverService.updateTypeOfCover(typeOfSportBuilding);
    }
}
