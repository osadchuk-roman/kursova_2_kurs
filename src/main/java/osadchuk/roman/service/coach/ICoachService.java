package osadchuk.roman.service.coach;

import osadchuk.roman.model.Coach;

import java.util.List;

public interface ICoachService {
    List<Coach> getAll();
    Coach insert(Coach coach);
    Coach update(Coach coach);
    Coach getById(int id);
    void delete(int id);
}
