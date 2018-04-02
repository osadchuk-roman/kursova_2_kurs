package osadchuk.roman.DAO.typeOfCover.interfaces;

import osadchuk.roman.model.TypeOfCover;

import java.util.List;

public interface ITypeOfCoverDAO {
    public TypeOfCover insertTypeOfCover(TypeOfCover typeOfCover);
    public TypeOfCover getTypeOfCover(int id);
    public TypeOfCover updateTypeOfCover(TypeOfCover typeOfCover);
    public TypeOfCover deleteTypeOfCover(int id);
    public List<TypeOfCover> getAll();
}
