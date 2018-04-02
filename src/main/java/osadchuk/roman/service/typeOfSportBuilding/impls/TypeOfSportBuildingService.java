package osadchuk.roman.service.typeOfSportBuilding.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.typeOfSportBuilding.impls.TypeOfSportBuildingDAOFakeImpl;
import osadchuk.roman.model.TypeOfSportBuilding;
import osadchuk.roman.service.typeOfSportBuilding.interfaces.ITypeOfSportBuildingService;

import java.util.List;

@Service
public class TypeOfSportBuildingService implements ITypeOfSportBuildingService {
    @Autowired
    TypeOfSportBuildingDAOFakeImpl typeOfSportBuildingDAO;


    @Override
    public TypeOfSportBuilding insertTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) {
        return typeOfSportBuildingDAO.insertTypeOfSportBuilding(typeOfSportBuilding);
    }

    @Override
    public TypeOfSportBuilding getTypeOfSportBuilding(int id) {
        return typeOfSportBuildingDAO.getTypeOfSportBuilding(id);
    }

    @Override
    public TypeOfSportBuilding updateTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) {
        return typeOfSportBuildingDAO.updateTypeOfSportBuilding(typeOfSportBuilding);
    }

    @Override
    public TypeOfSportBuilding deleteTypeOfSportBuilding(int id) {
        return typeOfSportBuildingDAO.deleteTypeOfSportBuilding(id);
    }

    @Override
    public List<TypeOfSportBuilding> getAll() {
        return typeOfSportBuildingDAO.getAll();
    }
}
