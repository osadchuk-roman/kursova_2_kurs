package osadchuk.roman.datastorage;

import org.springframework.context.annotation.Configuration;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataStorageFake {

    public List<KindOfSport> kindsOfSports = new ArrayList<>(
            Arrays.asList(
            new KindOfSport(1,"бокс"),
            new KindOfSport(2,"плавання"),
            new KindOfSport(3,"теніс"),
            new KindOfSport(4,"легка атлетика"),
            new KindOfSport(5,"спортивна гімнастика"),
            new KindOfSport(6,"вільна боротьба"),
            new KindOfSport(7,"стрибки у воду"),
            new KindOfSport(8,"легка атлетика"),
            new KindOfSport(9,"художня гімнастика"),
            new KindOfSport(10,"художня гімнастика"),
            new KindOfSport(11,"бадмінтон"),
            new KindOfSport(12,"дзюдо"),
            new KindOfSport(13,"армреслінг")
    ));
    public List<KindOfSport> getKindsOfSports(){
        return kindsOfSports;
    }

    public List<TypeOfCover> typesOfCover = new ArrayList<>(
            Arrays.asList(
                    new TypeOfCover(1,	"трав'яне"),
                    new TypeOfCover(2,	"ґрунтове"),
                    new TypeOfCover(3,	"килимове"),
                    new TypeOfCover(4,	"тверде")
            )
    );

    public List<TypeOfCover> getTypesOfCover() {
        return typesOfCover;
    }

    public List<TypeOfSportBuilding> typesOfSportBuilding = new ArrayList<>(
            Arrays.asList(
                    new TypeOfSportBuilding(1,	"стадіон"),
                    new TypeOfSportBuilding(2,	"манеж"),
                    new TypeOfSportBuilding(3,	"спортивна зала"),
                    new TypeOfSportBuilding(4,	"корт"),
                    new TypeOfSportBuilding(5,	"басейн")
            )
    );

    public List<TypeOfSportBuilding> getTypesOfSportBuilding() {
        return typesOfSportBuilding;
    }
}
