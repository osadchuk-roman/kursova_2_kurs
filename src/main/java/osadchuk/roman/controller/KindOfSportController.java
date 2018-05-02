package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.service.KindOfSportService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KindOfSportController {
    @Autowired
    KindOfSportService service;

    @RequestMapping("/kind_of_sport")
    public List<KindOfSport> getAll(){
        return service.getAll();
    }

    @RequestMapping("/kind_of_sport/get")
    public KindOfSport getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/kind_of_sport/delete")
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
