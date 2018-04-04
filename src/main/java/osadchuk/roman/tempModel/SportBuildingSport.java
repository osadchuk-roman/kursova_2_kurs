package osadchuk.roman.tempModel;



public class SportBuildingSport {

  private long id;
  private long sportBuildingId;
  private long kindOfSportId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSportBuildingId() {
    return sportBuildingId;
  }

  public void setSportBuildingId(long sportBuildingId) {
    this.sportBuildingId = sportBuildingId;
  }


  public long getKindOfSportId() {
    return kindOfSportId;
  }

  public void setKindOfSportId(long kindOfSportId) {
    this.kindOfSportId = kindOfSportId;
  }

}
