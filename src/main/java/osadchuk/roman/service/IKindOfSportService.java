package osadchuk.roman.service;

import osadchuk.roman.model.KindOfSport;

import java.util.List;

public interface IKindOfSportService {
    List<KindOfSport> getAll();
    KindOfSport insert(KindOfSport kindOfSport);
    KindOfSport update(KindOfSport kindOfSport);
    KindOfSport getById(int id);
    void delete(int id);

}
