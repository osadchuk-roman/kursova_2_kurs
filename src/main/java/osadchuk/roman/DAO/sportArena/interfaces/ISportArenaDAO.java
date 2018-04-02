package osadchuk.roman.DAO.sportArena.interfaces;

import osadchuk.roman.model.SportArena;

import java.util.List;

public interface ISportArenaDAO {
    public SportArena insertSportArena(SportArena sportArena);
    public SportArena getSportArena(int id);
    public SportArena updateSportArena(SportArena sportArena);
    public SportArena deleteSportArena(int id);
    public List<SportArena> getAll();
}
