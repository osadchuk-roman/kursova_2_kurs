package osadchuk.roman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.service.KindOfSportService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    KindOfSportService service;

    //@RequestMapping("/kind_of_sport")
    public List<KindOfSport> getAll(){
        return service.getAll();
    }
}
