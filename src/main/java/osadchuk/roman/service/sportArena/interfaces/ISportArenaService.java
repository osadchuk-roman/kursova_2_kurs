package osadchuk.roman.service.sportArena.interfaces;

import osadchuk.roman.model.SportArena;

import java.util.List;

public interface ISportArenaService {
    public SportArena insertSportArena(SportArena sportArena);
    public SportArena getSportArena(int id);
    public SportArena updateSportArena(SportArena sportArena);
    public SportArena deleteSportArena(int id);
    public List<SportArena> getAll();
}
