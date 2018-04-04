package osadchuk.roman.tempModel;



public class SportsmanCompetition {

  private long id;
  private long sportsmanId;
  private long competitionId;
  private long prizePlace;


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


  public long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(long competitionId) {
    this.competitionId = competitionId;
  }


  public long getPrizePlace() {
    return prizePlace;
  }

  public void setPrizePlace(long prizePlace) {
    this.prizePlace = prizePlace;
  }

}
