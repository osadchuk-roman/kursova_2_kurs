package osadchuk.roman.tempModel;

public class Coach {

  private long id;
  private String name;
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


  public long getSportClubId() {
    return sportClubId;
  }

  public void setSportClubId(long sportClubId) {
    this.sportClubId = sportClubId;
  }

}
