package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.*;
import osadchuk.roman.service.sportCategory.impls.SportCategoryService;
import osadchuk.roman.service.sportsmanSportCoach.impls.SportsmanSportCoachService;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanSportCoachController {
    @Autowired
    SportsmanSportCoachService sportsmanSportCoachService;
    @RequestMapping("/sportsman_sport_coach")
    public List<SportsmanSportCoach> showKindsOfSport() throws SQLException {
        return sportsmanSportCoachService.getAll();
    }

    @RequestMapping("/sportsman_sport_coach/del")
    public SportsmanSportCoach delCoach(@RequestParam int id) throws SQLException {
        return sportsmanSportCoachService.deleteSportsmanSportCoach(id);
    }
    /*@PostMapping("/sportsman_sport_coach/insert")
    public SportsmanSportCoach insert(@RequestBody SportsmanSportCoach sportsmanSportCoach) throws SQLException {
       return sportsmanSportCoachService.insertSportsmanSportCoach(sportsmanSportCoach);
    }*/
    @RequestMapping("/sportsman_sport_coach/insert")
    public SportsmanSportCoach insert(@RequestParam int sportsmanId, int sportId, int categoryId, int coachId) throws SQLException {
        Sportsman sportsman=new Sportsman(sportsmanId,null,0,null,null);
        KindOfSport kindOfSport = new KindOfSport(sportId,null);
        Coach coach =new Coach(coachId, null,null);
        SportCategory sportCategory = new SportCategory(categoryId,null);
        SportsmanSportCoach sportsmanSportCoach=new SportsmanSportCoach(
                0,
                sportsman,
                kindOfSport,
                sportCategory,
                coach
        );
        return sportsmanSportCoachService.insertSportsmanSportCoach(sportsmanSportCoach);
    }


    /*@PostMapping("/sportsman_sport_coach/update")
    public SportsmanSportCoach update(@RequestBody SportsmanSportCoach sportsmanSportCoach) throws SQLException {
        return sportsmanSportCoachService.updateSportsmanSportCoach(sportsmanSportCoach);
    }*/

    @RequestMapping("/sportsman_sport_coach/update")
    public SportsmanSportCoach update(@RequestParam int id, int sportsmanId, int sportId, int categoryId, int coachId) throws SQLException {
        Sportsman sportsman=new Sportsman(sportsmanId,null,0,null,null);
        KindOfSport kindOfSport = new KindOfSport(sportId,null);
        Coach coach =new Coach(coachId, null,null);
        SportCategory sportCategory = new SportCategory(categoryId,null);
        SportsmanSportCoach sportsmanSportCoach=new SportsmanSportCoach(
                id,
                sportsman,
                kindOfSport,
                sportCategory,
                coach
        );
        return sportsmanSportCoachService.updateSportsmanSportCoach(sportsmanSportCoach);
    }
}
