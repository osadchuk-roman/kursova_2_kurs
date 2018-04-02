package osadchuk.roman.service.kindOfSport.interfaces;

import osadchuk.roman.model.KindOfSport;

import java.util.List;

public interface IKindOfSportService {
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport);
    public KindOfSport getKindOfSport(int id);
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport);
    public KindOfSport deleteKindOfSport(int id);
    public List<KindOfSport> getAll();
}
