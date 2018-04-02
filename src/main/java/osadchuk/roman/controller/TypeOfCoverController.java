package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.service.typeOfCover.impls.TypeOfCoverService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfCoverController {
    @Autowired
    TypeOfCoverService typeOfCoverService;

    @RequestMapping("/type_of_cover")
    public List<TypeOfCover> showTypesOfSport(){
        return typeOfCoverService.getAll();
    }
}
