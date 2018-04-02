package osadchuk.roman.service.stadium.interfaces;

import osadchuk.roman.model.Stadium;

import java.util.List;

public interface IStadiumService {
    public Stadium insertStadium(Stadium stadium);
    public Stadium getStadium(int id);
    public Stadium updateStadium(Stadium stadium);
    public Stadium deleteStadium(int id);
    public List<Stadium> getAll();
}
