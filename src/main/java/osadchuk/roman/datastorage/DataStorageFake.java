package osadchuk.roman.datastorage;

import org.springframework.context.annotation.Configuration;
import osadchuk.roman.model.*;

import java.sql.Date;
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






    public List<SportBuilding> sportBuilding = new ArrayList<>(
            Arrays.asList(
                    new SportBuilding(1,"стадіон \"Здоров'я\"",getTypesOfSportBuilding().get(0),
                            "+380503191557","просп. Лесі Українки, 14"),
                    new SportBuilding(2,"спортивна зала \"Strong men\"",getTypesOfSportBuilding().get(2),
                            "+380997799015","пров. Тараса Шевченка, 46"),
                    new SportBuilding(3,"манеж \"Спортивне життя\"",getTypesOfSportBuilding().get(1),
                            "+380673009699","пров. Гагаріна, 25"),
                    new SportBuilding(4,"басейн \"Aqua world\"",getTypesOfSportBuilding().get(4),
                            "+380639711647","вул. Тараса Шевченка, 51"),
                    new SportBuilding(5,"корт \"VIP tennis\"",getTypesOfSportBuilding().get(3),
                            "+380933209646","вул. Пацаєва, 73"),
                    new SportBuilding(6,"стадіон \"Олімпійський\"",getTypesOfSportBuilding().get(0),
                            "+380934509317","вул. Сонячна, 22А"),
                    new SportBuilding(7,"спортивна зала \"Титан\"",getTypesOfSportBuilding().get(2),
                            "+380676704124","вул. Івана Франка, 54"),
                    new SportBuilding(8,"басейн \"The Best Swimming\"",getTypesOfSportBuilding().get(4),
                            "+380932706830","вул. Перемоги, 21"),
                    new SportBuilding(9,"манеж \"Гімнастичний\"",getTypesOfSportBuilding().get(1),
                            "+380676296494","вул, Головна, 209"),
                    new SportBuilding(10,"манеж \"Здоровий дух\"",getTypesOfSportBuilding().get(1),
                            "+380638344757","вул, Червона, 67")
            )
    );
    public List<SportBuilding> getSportBuilding() {
        return sportBuilding;
    }

    public List<Gym> gym = new ArrayList<>(
            Arrays.asList(
                    new Gym(1,getSportBuilding().get(1),true,true,true),
                    new Gym(2,getSportBuilding().get(6),true,false,false)
            )
    );

    public  List<Gym> getGyms(){return gym;}

    public List<Stadium> stadiums = new ArrayList<>(
            Arrays.asList(
                    new Stadium(1,getSportBuilding().get(0),5000,4500,true,false),
                    new Stadium(2,getSportBuilding().get(5),4500,5700,true,true)
            )
    );

    public  List<Stadium> getStadiums(){return stadiums;}

    public List<SportArena> sportArenas = new ArrayList<>(
            Arrays.asList(
                    new SportArena(1,getSportBuilding().get(2),2500,false,true,true),
                    new SportArena(2,getSportBuilding().get(8),2750,true,false,false),
                    new SportArena(3,getSportBuilding().get(9),2000,true,false,true)
            )
    );

    public  List<SportArena> getSportArena(){return sportArenas;}

    public List<Court> courts = new ArrayList<>(
            Arrays.asList(
                    new Court(1,getSportBuilding().get(4),getTypesOfCover().get(1),8.2,23.7)
            )
    );

    public  List<Court> getCourts(){return courts;}

    public List<Pool> pools = new ArrayList<>(
            Arrays.asList(
                    new Pool(1,getSportBuilding().get(3),4,10,50,7),
                    new Pool(2,getSportBuilding().get(7),5,15,30,10)
            )
    );

    public  List<Pool> getPools(){return pools;}

    public List<SportClub> sportClubs = new ArrayList<>(
            Arrays.asList(
                    new SportClub(1,"Здорова молодь","Прокопчук Л.І.",
                            "+380502193401","вул. Головна, 12"),
                    new SportClub(2,"Strong men","Фідіпенко П.О.",
                            "+380936713674","вул. Краматорська, 123"),
                    new SportClub(3,"Bushido","Сарницький А.А.",
                            "+380996019733","вул. Івана Багряного, 35"),
                    new SportClub(4,"Олімпік","Ворбенко Д.О.",
                            "+380671775477","пров. Активістів, 21"),
                    new SportClub(5,"Атлет","Федорчук В.І.",
                            "+380960498287","вул. Степана Бандери, 45"),
                    new SportClub(6,"Elite tennis club","Петренюк Л.І.",
                            "+380635219128","вул. Київська, 89"),
                    new SportClub(7,"Спартанець","Косецький В.П.",
                            "+380679523532","бульвар Просвіти, 101"),
                    new SportClub(8,"Swimming Masters Club","Загородній К.П.",
                            "+380961007474","вул. Вільхова, 23")
            )
    );

    public  List<SportClub> getSportClubs(){return sportClubs;}


    public List<Coach> coaches = new ArrayList<>(
            Arrays.asList(
                    new Coach(1,"Гринчук В. М.",getSportClubs().get(0)),
                    new Coach(2,"Калиниченко Р. В.",getSportClubs().get(0)),
                    new Coach(3,"Піць О. І.",getSportClubs().get(0)),
                    new Coach(4,"Ломаченко П. О.",getSportClubs().get(1)),
                    new Coach(5,"Войцов І. С.",getSportClubs().get(1)),
                    new Coach(6,"Панасюк Л. Д.",getSportClubs().get(1)),
                    new Coach(7,"Широкін А. О.",getSportClubs().get(2)),
                    new Coach(8,"Захарчук М. А.",getSportClubs().get(2)),
                    new Coach(9,"Чигиринський П. Р.",getSportClubs().get(2)),
                    new Coach(10,"Краснельський І.В.",getSportClubs().get(2))
            )
    );

    public  List<Coach> getCoaches(){return coaches;}

    public List<Sportsman> sportsmen = new ArrayList<>(
            Arrays.asList(
                    new Sportsman(1,	"Микитюк Є. Б.",	16,	"чоловіча",	getSportClubs().get(0)),
                    new Sportsman(2,	"Захарчук Г. А.",	17,	"чоловіча",	getSportClubs().get(0)),
                    new Sportsman(3,	"Броваренко Н. О.",	17,	"чоловіча",	getSportClubs().get(0)),
                    new Sportsman(4,	"Петренко Н.А.",	18,	"чоловіча",	getSportClubs().get(0)),
                    new Sportsman(5,	"Мірошниченко А. М.",	15,	"жіноча",	getSportClubs().get(0)),
                    new Sportsman(6,	"Романченко Л. В.",	17,	"жіноча",	getSportClubs().get(0)),
                    new Sportsman(7,	"Шевчук Н. М.",	19,	"жіноча",	getSportClubs().get(0)),
                    new Sportsman(8,	"Іванова А. О.",	18,	"жіноча",	getSportClubs().get(0)),
                    new Sportsman(9,	"Павлюк Є.Є.",	20,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(10,	"Кирилюк М. А.",	19,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(11,	"Парасюк М. Т.",	21,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(12,	"Гордієнко К. О.",	18,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(13,	"Іваненеко А. О.",	19,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(14,	"Кириленко Р. Р.",	18,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(15,	"Кравчук І. Я.",	20,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(16,	"Гречин Н. К.",	22,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(17,	"Василенко М. О.",	21,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(18,	"Кравченко О. І.",	23,	"чоловіча",	getSportClubs().get(1)),
                    new Sportsman(19,	"Мельниченко Р. О.",	17,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(20,	"Петров П. М.",	16,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(21,	"Ломаченко Д. О.",	15,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(22,	"Ворошивчук Н. Л.",	18,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(23,	"Степаненко Л.Д.",	17,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(24,	"Чайковський М. І.",	19,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(25,	"Бойчук Д. А.",	20,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(26,	"Панчук А. І.",	16,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(27,	"Чижов Д. Н.",	18,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(28,	"Остафійчук Г. Г.",	19,	"чоловіча",	getSportClubs().get(2)),
                    new Sportsman(29,	"Леонідов Р. Д.",	19,	"чоловіча",	getSportClubs().get(0)),
                    new Sportsman(30,	"Карпенко В. Г.",	17,	"чоловіча",	getSportClubs().get(2))
            )
    );
    public  List<Sportsman> getSportsmen(){return sportsmen;}

    public List<SportCategory> sportCategories = new ArrayList<>(
            Arrays.asList(
                    new SportCategory(1,"МСМК"),
                    new SportCategory(2,"МСУ"),
                    new SportCategory(3,"КМСУ"),
                    new SportCategory(4,"І розряд"),
                    new SportCategory(5,"ІІ розряд"),
                    new SportCategory(6,"ІІІ розряд")
            )
    );
    public  List<SportCategory> getSportCategories(){return sportCategories;}

    public List<SportsmanSportCoach> sportsmanSportCoaches = new ArrayList<>(
            Arrays.asList(
                    new SportsmanSportCoach(1,getSportsmen().get(0),getKindsOfSports().get(3), getSportCategories().get(3),getCoaches().get(0)),
                    new SportsmanSportCoach(2,getSportsmen().get(1),getKindsOfSports().get(3), getSportCategories().get(2),getCoaches().get(0)),
                    new SportsmanSportCoach(3,getSportsmen().get(2),getKindsOfSports().get(3), getSportCategories().get(2),getCoaches().get(1))
            )
    );
    public  List<SportsmanSportCoach> getSportsmanSportCoaches(){return sportsmanSportCoaches;}

    public List<Organizer> organizers = new ArrayList<>(
            Arrays.asList(
                    new Organizer(1,"Спортивно-оздоровча організація \"Здорове життя\"","Микитюк М.Т.",
                            "+380968907806","вул. Квіткова, 1"),
                    new Organizer(2,"Спортивна організація \"Нова Олімпія\"","Захаренко П.О.",
                            "+380992919429","вул. Лесі Українки, 24"),
                    new Organizer(3,"Міська організація \"Спорт - це життя\"","Строцький О.Л.",
                            "+380963922633","вул. Дорошенка, 65"),
                    new Organizer(4,"Спортивна організація \"Мистецтво бою\"","Ломарюк Л.Д.",
                            "+380505403454","просп. Перемоги,23"),
                    new Organizer(5,"Організація \"Здорове місто\"","Цирилюк Р.Т.",
                            "+380670787880","пров. Серпневої, 21"),
                    new Organizer(6,"Організація \"Сильні духом\"","Шовковий Н.Л.",
                            "+380934719982","вул. Небесної сотні, 35")
            )
    );
    public  List<Organizer> getOrganizes(){return organizers;}

    public List<Competition> competitions = new ArrayList<>(
            Arrays.asList(
                    new Competition(1,"Міський турнір з боксу серед юнаків",new Date(2015-02-20),getOrganizes().get(3),
                            getSportBuilding().get(1),getKindsOfSports().get(0)),
                    new Competition(2,"Змагання з карате серед юнаків",new Date(2015-04-15),getOrganizes().get(3),
                            getSportBuilding().get(2),getKindsOfSports().get(9)),
                    new Competition(3,"Турнір за клубну першість",new Date(2015-06-01),getOrganizes().get(2),
                            getSportBuilding().get(9),getKindsOfSports().get(11)),
                    new Competition(4,"Турнір \"Strong hand\"",new Date(2015-06-19),getOrganizes().get(5),
                            getSportBuilding().get(6),getKindsOfSports().get(12)),
                    new Competition(5,"Клубний турнір з тенісу",new Date(2015-07-01),getOrganizes().get(4),
                            getSportBuilding().get(4),getKindsOfSports().get(2))
            )
    );
    public  List<Competition> getCompetitions(){return competitions;}

    public List<SportBuildingSport> sportBuildingSports = new ArrayList<>(
            Arrays.asList(
                    new SportBuildingSport(1,getSportBuilding().get(0),getKindsOfSports().get(3)),
                    new SportBuildingSport(2,getSportBuilding().get(1),getKindsOfSports().get(0)),
                    new SportBuildingSport(3,getSportBuilding().get(1),getKindsOfSports().get(7)),
                    new SportBuildingSport(4,getSportBuilding().get(1),getKindsOfSports().get(12)),
                    new SportBuildingSport(5,getSportBuilding().get(2),getKindsOfSports().get(0)),
                    new SportBuildingSport(6,getSportBuilding().get(2),getKindsOfSports().get(12)),
                    new SportBuildingSport(7,getSportBuilding().get(2),getKindsOfSports().get(5)),
                    new SportBuildingSport(8,getSportBuilding().get(2),getKindsOfSports().get(9)),
                    new SportBuildingSport(9,getSportBuilding().get(2),getKindsOfSports().get(11)),
                    new SportBuildingSport(10,getSportBuilding().get(3),getKindsOfSports().get(1)),
                    new SportBuildingSport(11,getSportBuilding().get(3),getKindsOfSports().get(6)),
                    new SportBuildingSport(12,getSportBuilding().get(4),getKindsOfSports().get(2)),
                    new SportBuildingSport(13,getSportBuilding().get(4),getKindsOfSports().get(10)),
                    new SportBuildingSport(14,getSportBuilding().get(5),getKindsOfSports().get(3)),
                    new SportBuildingSport(15,getSportBuilding().get(5),getKindsOfSports().get(4)),
                    new SportBuildingSport(16,getSportBuilding().get(6),getKindsOfSports().get(7)),
                    new SportBuildingSport(17,getSportBuilding().get(6),getKindsOfSports().get(12)),
                    new SportBuildingSport(18,getSportBuilding().get(7),getKindsOfSports().get(1)),
                    new SportBuildingSport(19,getSportBuilding().get(7),getKindsOfSports().get(6)),
                    new SportBuildingSport(20,getSportBuilding().get(8),getKindsOfSports().get(4)),
                    new SportBuildingSport(21,getSportBuilding().get(8),getKindsOfSports().get(8)),
                    new SportBuildingSport(22,getSportBuilding().get(9),getKindsOfSports().get(3)),
                    new SportBuildingSport(23,getSportBuilding().get(9),getKindsOfSports().get(5)),
                    new SportBuildingSport(24,getSportBuilding().get(9),getKindsOfSports().get(9)),
                    new SportBuildingSport(25,getSportBuilding().get(9),getKindsOfSports().get(11))
            )
    );
    public  List<SportBuildingSport> getSportBuildingSports(){return sportBuildingSports;}

    public List<SportsmanCompetition> sportsmanCompetitions = new ArrayList<>(
            Arrays.asList(
                    new SportsmanCompetition(1,getSportsmen().get(8),getCompetitions().get(0),12),
                    new SportsmanCompetition(2,getSportsmen().get(9),getCompetitions().get(0),11),
                    new SportsmanCompetition(3,getSportsmen().get(10),getCompetitions().get(0),1),
                    new SportsmanCompetition(4,getSportsmen().get(11),getCompetitions().get(0),9),
                    new SportsmanCompetition(5,getSportsmen().get(12),getCompetitions().get(0),10),
                    new SportsmanCompetition(6,getSportsmen().get(13),getCompetitions().get(0),8),
                    new SportsmanCompetition(7,getSportsmen().get(14),getCompetitions().get(0),6),
                    new SportsmanCompetition(8,getSportsmen().get(15),getCompetitions().get(0),7),
                    new SportsmanCompetition(9,getSportsmen().get(16),getCompetitions().get(0),4),
                    new SportsmanCompetition(10,getSportsmen().get(17),getCompetitions().get(0),5),
                    new SportsmanCompetition(11,getSportsmen().get(18),getCompetitions().get(0),3),
                    new SportsmanCompetition(12,getSportsmen().get(19),getCompetitions().get(0),2)
            )
    );
    public  List<SportsmanCompetition> getSportsmanCompetitions(){return sportsmanCompetitions;}




}
