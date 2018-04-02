package osadchuk.roman.DAO.sportBuildingSport.interfaces;

import osadchuk.roman.model.SportBuildingSport;

import java.util.List;

public interface ISportBuildingSportDAO {
    public SportBuildingSport insertSportBuildingSport(SportBuildingSport sportBuildingSport);
    public SportBuildingSport getSportBuildingSport(int id);
    public SportBuildingSport updateSportBuildingSport(SportBuildingSport sportBuildingSport);
    public SportBuildingSport deleteSportBuildingSport(int id);
    public List<SportBuildingSport> getAll();
}
