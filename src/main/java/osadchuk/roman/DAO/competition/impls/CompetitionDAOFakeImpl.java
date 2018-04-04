package osadchuk.roman.DAO.competition.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.competition.interfaces.ICompetitionDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Competition;

import java.util.List;

@Component
public class CompetitionDAOFakeImpl implements ICompetitionDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public Competition insertCompetition(Competition competition) {
        dataStorage.getCompetitions().add(competition);
        return competition;
    }

    @Override
    public Competition getCompetition(int id) {
        return dataStorage.getCompetitions().get(id);
    }

    @Override
    public Competition updateCompetition(Competition competition) {
        for (Competition c : dataStorage.getCompetitions()) {
            if(c.getId() == competition.getId()){
                c.setName(competition.getName());
                c.setDate(competition.getDate());
                c.setOrganizer(competition.getOrganizer());
                c.setSportBuilding(competition.getSportBuilding());
                c.setKindOfSport(competition.getKindOfSport());
                break;
            }
        }
        return competition;
    }

    @Override
    public Competition deleteCompetition(int id) {
        Competition competition = dataStorage.getCompetitions()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getCompetitions().indexOf(competition);
        dataStorage.getCompetitions().remove(index);
        return competition;
    }

    @Override
    public List<Competition> getAll() {
        return dataStorage.getCompetitions();
    }
}
