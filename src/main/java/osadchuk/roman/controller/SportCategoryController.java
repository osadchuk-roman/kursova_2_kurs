package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.SportCategory;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.service.sportCategory.impls.SportCategoryService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportCategoryController {
    @Autowired
    SportCategoryService sportCategoryService;
    @RequestMapping("/sport_category")
    public List<SportCategory> show() throws SQLException {
        return sportCategoryService.getAll();
    }
    @RequestMapping("/sport_category/del")
    public SportCategory delete(@RequestParam int id) throws SQLException {
        return sportCategoryService.deleteSportCategory(id);
    }
}
