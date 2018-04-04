package osadchuk.roman.tempModel;


public class SportsmanSportCoach {

  private long id;
  private long sportsmanId;
  private long kindOfSportId;
  private long sportCategoryId;
  private long coachId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSportsmanId() {
    return sportsmanId;
  }

  public void setSportsmanId(long sportsmanId) {
    this.sportsmanId = sportsmanId;
  }


  public long getKindOfSportId() {
    return kindOfSportId;
  }

  public void setKindOfSportId(long kindOfSportId) {
    this.kindOfSportId = kindOfSportId;
  }


  public long getsportCategoryId() {
    return sportCategoryId;
  }

  public void sportCategoryId(long sportCategoryId) {
    this.sportCategoryId = sportCategoryId;
  }


  public long getCoachId() {
    return coachId;
  }

  public void setCoachId(long coachId) {
    this.coachId = coachId;
  }

}
