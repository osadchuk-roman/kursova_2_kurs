package osadchuk.roman.DAO.sportCategory.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportCategory.interfaces.ISportCategoryDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.SportCategory;

import java.util.List;

@Component
public class SportCategoryDAOFakeImpl implements ISportCategoryDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public SportCategory insertSportCategory(SportCategory sportCategory) {
         dataStorage.getSportCategories().add(sportCategory);
         return sportCategory;
    }

    @Override
    public SportCategory getSportCategory(int id) {
        return dataStorage.getSportCategories().get(id);
    }

    @Override
    public SportCategory updateSportCategory(SportCategory sportCategory) {
        for (SportCategory s : dataStorage.getSportCategories()) {
            if(s.getId() == sportCategory.getId()){
                s.setName(sportCategory.getName());
                break;
            }
        }
        return sportCategory;
    }

    @Override
    public SportCategory deleteSportCategory(int id) {
        SportCategory sportCategory = dataStorage.getSportCategories()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportCategories().indexOf(sportCategory);
        dataStorage.getSportCategories().remove(index);
        return sportCategory;
    }

    @Override
    public List<SportCategory> getAll() {
        return dataStorage.getSportCategories();
    }
}
