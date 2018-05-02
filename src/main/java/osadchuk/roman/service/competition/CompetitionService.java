package osadchuk.roman.service.competition;

import org.springframework.beans.factory.annotation.Autowired;
import osadchuk.roman.model.Coach;
import osadchuk.roman.repository.CoachRepository;

import java.util.List;

public class CompetitionService implements ICompetitionService {
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
