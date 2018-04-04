package osadchuk.roman.tempModel;



public class Sportsman {

  private long id;
  private String name;
  private long age;
  private String gender;
  private long sportClubId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public long getSportClubId() {
    return sportClubId;
  }

  public void setSportClubId(long sportClubId) {
    this.sportClubId = sportClubId;
  }

}
