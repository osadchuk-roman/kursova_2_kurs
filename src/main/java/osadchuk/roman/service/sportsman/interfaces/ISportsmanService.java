package osadchuk.roman.service.sportsman.interfaces;

import osadchuk.roman.model.Sportsman;

import java.util.List;

public interface ISportsmanService {
    public Sportsman insertSportsman(Sportsman sportsman);
    public Sportsman getSportsman(int id);
    public Sportsman updateSportsman(Sportsman sportsman);
    public Sportsman deleteSportsman(int id);
    public List<Sportsman> getAll();
}
