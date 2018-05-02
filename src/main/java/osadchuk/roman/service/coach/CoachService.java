package osadchuk.roman.service.coach;

import org.springframework.beans.factory.annotation.Autowired;
import osadchuk.roman.model.Coach;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.repository.CoachRepository;
import osadchuk.roman.repository.KindOfSportRepository;

import java.util.List;

public class CoachService implements ICoachService {
    @Autowired
    CoachRepository repository;
    @Override
    public List<Coach> getAll() {
        return (List<Coach>)repository.findAll();
    }

    @Override
    public Coach insert(Coach coach) {
        return repository.save(coach);
    }

    @Override
    public Coach update(Coach coach) {
        return repository.save(coach);
    }

    @Override
    public Coach getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
