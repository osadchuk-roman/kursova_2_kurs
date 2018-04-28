package osadchuk.roman.DAO.sportBuildingSport.interfaces;

import osadchuk.roman.model.SportBuildingSport;

import java.sql.SQLException;
import java.util.List;

public interface ISportBuildingSportDAO {
    public SportBuildingSport insertSportBuildingSport(SportBuildingSport sportBuildingSport) throws SQLException;
    public SportBuildingSport getSportBuildingSport(int id) throws SQLException;
    public SportBuildingSport updateSportBuildingSport(SportBuildingSport sportBuildingSport) throws SQLException;
    public SportBuildingSport deleteSportBuildingSport(int id) throws SQLException;
    public List<SportBuildingSport> getAll() throws SQLException;
}
