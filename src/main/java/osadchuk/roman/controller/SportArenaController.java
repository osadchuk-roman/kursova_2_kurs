package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.service.sportArena.impls.SportArenaService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportArenaController {
    @Autowired
    SportArenaService sportArenaService;
    @RequestMapping("/sport_arena")
    public List<SportArena> showKindsOfSport() throws SQLException {
        return sportArenaService.getAll();
    }
}
