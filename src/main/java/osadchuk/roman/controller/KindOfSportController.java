package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.service.kindOfSport.impls.KindOfSportService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class KindOfSportController {
    @Autowired
    KindOfSportService kindOfSportService;

    @RequestMapping("/kind_of_sport")
    public List<KindOfSport> show() throws SQLException {
        return kindOfSportService.getAll();
    }
    @RequestMapping("/kind_of_sport/del")
    public KindOfSport delete(@RequestParam int id) throws SQLException {
        return kindOfSportService.deleteKindOfSport(id);
    }

}
