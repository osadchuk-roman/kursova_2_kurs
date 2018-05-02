package osadchuk.roman.service.kindOfSport;

import osadchuk.roman.model.KindOfSport;

import java.util.List;

public interface IKindOfSportService {
    List<KindOfSport> getAll();
    KindOfSport insert(KindOfSport kindOfSport);
    KindOfSport update(KindOfSport kindOfSport);
    KindOfSport getById(int id);
    void delete(int id);

}
