package osadchuk.roman.service.typeOfCover.interfaces;

import osadchuk.roman.model.TypeOfCover;

import java.util.List;

public interface ITypeOfCoverService {
    public TypeOfCover insertTypeOfCover(TypeOfCover typeOfCover);
    public TypeOfCover getTypeOfCover(int id);
    public TypeOfCover updateTypeOfCover(TypeOfCover typeOfCover);
    public TypeOfCover deleteTypeOfCover(int id);
    public List<TypeOfCover> getAll();
}
