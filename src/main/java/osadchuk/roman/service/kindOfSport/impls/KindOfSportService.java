package osadchuk.roman.service.kindOfSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.kindOfSport.impls.KindOfSportDAOFakeImpl;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.service.kindOfSport.interfaces.IKindOfSportService;

import java.util.List;

@Service
public class KindOfSportService implements IKindOfSportService {
    @Autowired
    KindOfSportDAOFakeImpl kindOfSportDAO;

    @Override
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport) {
        return kindOfSportDAO.insertKindOfSport(kindOfSport);
    }

    @Override
    public KindOfSport getKindOfSport(int id) {
        return kindOfSportDAO.getKindOfSport(id);
    }

    @Override
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport) {
        return kindOfSportDAO.updateKindOfSport(kindOfSport);
    }

    @Override
    public KindOfSport deleteKindOfSport(int id) {
        return kindOfSportDAO.deleteKindOfSport(id);
    }

    @Override
    public List<KindOfSport> getAll() {
        return kindOfSportDAO.getAll();
    }
}
