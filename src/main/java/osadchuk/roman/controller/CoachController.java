package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoachController {
    /*@Autowired
    CoachS service;

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

    @PostMapping("/kind_of_sport/insert")
    public KindOfSport insert(@RequestBody KindOfSport kindOfSport){

        return service.insert(kindOfSport);
    }

    @PostMapping("/kind_of_sport/update")
    public KindOfSport update(@RequestBody KindOfSport kindOfSport){

        return service.update(kindOfSport);
    }*/
}
