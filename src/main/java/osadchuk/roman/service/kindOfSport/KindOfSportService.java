package osadchuk.roman.service.kindOfSport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.repository.KindOfSportRepository;

import java.util.List;
@Service
public class KindOfSportService implements IKindOfSportService {
    @Autowired
    KindOfSportRepository repository;
    @Override
    public List<KindOfSport> getAll() {
        return (List<KindOfSport>)repository.findAll();
    }

    @Override
    public KindOfSport insert(KindOfSport kindOfSport) {
        return repository.save(kindOfSport);
    }

    @Override
    public KindOfSport update(KindOfSport kindOfSport) {
        return repository.save(kindOfSport);
    }

    @Override
    public KindOfSport getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
