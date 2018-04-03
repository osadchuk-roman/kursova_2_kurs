package osadchuk.roman.DAO.typeOfCover.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.typeOfCover.interfaces.ITypeOfCoverDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.TypeOfCover;

import java.util.List;

@Component
public class TypeOfCoverDAOFakeImpl implements ITypeOfCoverDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public TypeOfCover insertTypeOfCover(TypeOfCover typeOfCover) {
        dataStorage.getTypesOfCover().add(typeOfCover);
        return typeOfCover;
    }

    @Override
    public TypeOfCover getTypeOfCover(int id) {
        return dataStorage.getTypesOfCover().get(id);
    }

    @Override
    public TypeOfCover updateTypeOfCover(TypeOfCover typeOfCover) {
        for (TypeOfCover tc : dataStorage.getTypesOfCover()) {
            if(tc.getId() == typeOfCover.getId()){
                tc.setName(typeOfCover.getName());
                break;
            }
        }
        return typeOfCover;
    }

    @Override
    public TypeOfCover deleteTypeOfCover(int id) {
        TypeOfCover typeOfCover = dataStorage.getTypesOfCover()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getTypesOfCover().indexOf(typeOfCover);
        dataStorage.getTypesOfCover().remove(index);
        return typeOfCover;
    }

    @Override
    public List<TypeOfCover> getAll() {
        return dataStorage.getTypesOfCover();
    }
}
