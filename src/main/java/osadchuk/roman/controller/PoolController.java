package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Pool;
import osadchuk.roman.service.pool.impls.PoolService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PoolController {
    @Autowired
    PoolService poolService;
    @RequestMapping("/pool")
    public List<Pool> showKindsOfSport() throws SQLException {
        return poolService.getAll();
    }
}
