package osadchuk.roman.model;

public class Sportsman {
    public int id;
    public String name;
    public int age;
    public String gender;
    public SportClub sportClub;

    public Sportsman(int id, String name, int age, String gender, SportClub sportClub) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sportClub = sportClub;
    }

    public Sportsman() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public SportClub getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClub sportClub) {
        this.sportClub = sportClub;
    }
}
