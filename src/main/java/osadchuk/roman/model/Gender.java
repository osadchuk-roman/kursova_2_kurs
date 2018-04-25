package osadchuk.roman.model;

public class Gender {
    private int id;
    private String gender;

    public Gender() {
    }

    public Gender(int id, String gender) {

        this.id = id;
        this.gender = gender;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
