package osadchuk.roman.service.typeOfCover.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.typeOfCover.impls.TypeOfCoverDAOFakeImpl;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.service.typeOfCover.interfaces.ITypeOfCoverService;

import java.sql.SQLException;
import java.util.List;

@Service
public class TypeOfCoverService implements ITypeOfCoverService {
    @Autowired
    TypeOfCoverDAOFakeImpl typeOfCoverDAO;

    @Override
    public TypeOfCover insertTypeOfCover(TypeOfCover typeOfCover) throws SQLException {
        return typeOfCoverDAO.insertTypeOfCover(typeOfCover);
    }

    @Override
    public TypeOfCover getTypeOfCover(int id) throws SQLException {
        return typeOfCoverDAO.getTypeOfCover(id);
    }

    @Override
    public TypeOfCover updateTypeOfCover(TypeOfCover typeOfCover) throws SQLException {
        return typeOfCoverDAO.updateTypeOfCover(typeOfCover);
    }

    @Override
    public TypeOfCover deleteTypeOfCover(int id) throws SQLException {
        return typeOfCoverDAO.deleteTypeOfCover(id);
    }

    @Override
    public List<TypeOfCover> getAll() throws SQLException {
        return typeOfCoverDAO.getAll();
    }
}
