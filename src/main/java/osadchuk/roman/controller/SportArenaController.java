package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.sportArena.impls.SportArenaService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportArenaController {
    @Autowired
    SportArenaService sportArenaService;
    @RequestMapping("/sport_arena")
    public List<SportArena> getAll() throws SQLException {
        return sportArenaService.getAll();
    }

    @RequestMapping("/sport_arena/del")
    public SportArena del(@RequestParam int id) throws SQLException {
        return sportArenaService.deleteSportArena(id);
    }

    @RequestMapping("/sport_arena/insert")
    public SportArena insert(@RequestParam int sportBuildingId,int capacity,
                        boolean gymnastic, boolean box, boolean matirialArts) throws SQLException {

        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        SportArena sportArena=new SportArena(0,sportBuilding,capacity,gymnastic,box,matirialArts);
        return sportArenaService.insertSportArena(sportArena);
    }

    @RequestMapping("/sport_arena/update")
    public SportArena update(@RequestParam int id, int sportBuildingId,int capacity,
                             boolean gymnastic, boolean box, boolean matirialArts) throws SQLException {
        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        SportArena sportArena=new SportArena(id,sportBuilding,capacity,gymnastic,box,matirialArts);
        return sportArenaService.updateSportArena(sportArena);
    }
}
