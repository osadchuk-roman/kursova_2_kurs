package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Gym;
import osadchuk.roman.service.gym.impls.GymService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GymController {
    @Autowired
    GymService gymService;
    @RequestMapping("/gym")
    public List<Gym> showKindsOfSport() throws SQLException {
        return gymService.getAll();
    }
}
