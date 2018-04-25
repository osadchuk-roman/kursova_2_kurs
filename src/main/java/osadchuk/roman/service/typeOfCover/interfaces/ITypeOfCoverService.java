package osadchuk.roman.service.typeOfCover.interfaces;

import osadchuk.roman.model.TypeOfCover;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfCoverService {
    public TypeOfCover insertTypeOfCover(TypeOfCover typeOfCover) throws SQLException;
    public TypeOfCover getTypeOfCover(int id) throws SQLException;
    public TypeOfCover updateTypeOfCover(TypeOfCover typeOfCover) throws SQLException;
    public TypeOfCover deleteTypeOfCover(int id) throws SQLException;
    public List<TypeOfCover> getAll() throws SQLException;
}
