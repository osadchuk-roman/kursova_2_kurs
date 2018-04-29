package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.Pool;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.pool.impls.PoolService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PoolController {
    @Autowired
    PoolService poolService;
    @RequestMapping("/pool")
    public List<Pool> show() throws SQLException {
        return poolService.getAll();
    }

    @RequestMapping("/pool/del")
    public Pool del(@RequestParam int id) throws SQLException {
        return poolService.deletePool(id);
    }

    @RequestMapping("/pool/insert")
    public Pool insert(@RequestParam int sportBuildingId,int depth, int width, int length,
                                        int maxHeight) throws SQLException {

        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        Pool pool=new Pool(0,sportBuilding,depth,width,length,maxHeight);
        return poolService.insertPool(pool);
    }

    @RequestMapping("/pool/update")
    public Pool update(@RequestParam int id, int sportBuildingId,int depth, int width,
                      int length, int maxHeight) throws SQLException {
        SportBuilding sportBuilding = new SportBuilding(
                sportBuildingId,
                null,
                null,
                null,
                null
        );
        Pool pool=new Pool(id,sportBuilding,depth,width,length,maxHeight);
        return poolService.updatePool(pool);
    }
}
