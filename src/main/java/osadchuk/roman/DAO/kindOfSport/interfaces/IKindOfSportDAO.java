package osadchuk.roman.DAO.kindOfSport.interfaces;

import osadchuk.roman.model.KindOfSport;

import java.util.List;

public interface IKindOfSportDAO {
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport);
    public KindOfSport getKindOfSport(int id);
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport);
    public KindOfSport deleteKindOfSport(int id);
    public List<KindOfSport> getAll();
}
