package osadchuk.roman.DAO.typeOfSportBuilding.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.typeOfSportBuilding.interfaces.ITypeOfSportBuildingDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.util.List;

@Component
public class TypeOfSportBuildingDAOFakeImpl implements ITypeOfSportBuildingDAO{
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public TypeOfSportBuilding insertTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) {
        dataStorage.getTypesOfSportBuilding().add(typeOfSportBuilding);
        return typeOfSportBuilding;
    }

    @Override
    public TypeOfSportBuilding getTypeOfSportBuilding(int id) {
        return dataStorage.getTypesOfSportBuilding().get(id);
    }

    @Override
    public TypeOfSportBuilding updateTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) {
        for (TypeOfSportBuilding ts : dataStorage.getTypesOfSportBuilding()) {
            if(ts.getId() == typeOfSportBuilding.getId()){
                ts.setName(typeOfSportBuilding.getName());
                break;
            }
        }
        return typeOfSportBuilding;
    }

    @Override
    public TypeOfSportBuilding deleteTypeOfSportBuilding(int id) {
        TypeOfSportBuilding typeOfSportBuilding = dataStorage.getTypesOfSportBuilding()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getTypesOfSportBuilding().indexOf(typeOfSportBuilding);
        dataStorage.getTypesOfSportBuilding().remove(index);
        return typeOfSportBuilding;
    }

    @Override
    public List<TypeOfSportBuilding> getAll() {
        return dataStorage.getTypesOfSportBuilding();
    }
}
