package osadchuk.roman.service.competition;

import osadchuk.roman.model.Coach;
import osadchuk.roman.model.Competition;

import java.util.List;

public interface ICompetitionService {
    List<Competition> getAll();
    Competition insert(Competition competition);
    Competition update(Competition competition);
    Competition getById(int id);
    void delete(int id);
}
