package osadchuk.roman.service.kindOfSport.interfaces;

import osadchuk.roman.model.KindOfSport;

import java.sql.SQLException;
import java.util.List;

public interface IKindOfSportService {
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport) throws SQLException;
    public KindOfSport getKindOfSport(int id) throws SQLException;
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport) throws SQLException;
    public KindOfSport deleteKindOfSport(int id) throws SQLException;
    public List<KindOfSport> getAll() throws SQLException;
}
