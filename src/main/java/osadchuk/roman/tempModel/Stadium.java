package osadchuk.roman.tempModel;



public class Stadium {

  private long id;
  private long sportBuildingId;
  private long capaciity;
  private double fieldArea;
  private long presenceOfPathForRunnig;
  private long presenceOfGymnasticZone;


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


  public long getCapaciity() {
    return capaciity;
  }

  public void setCapaciity(long capaciity) {
    this.capaciity = capaciity;
  }


  public double getFieldArea() {
    return fieldArea;
  }

  public void setFieldArea(double fieldArea) {
    this.fieldArea = fieldArea;
  }


  public long getPresenceOfPathForRunnig() {
    return presenceOfPathForRunnig;
  }

  public void setPresenceOfPathForRunnig(long presenceOfPathForRunnig) {
    this.presenceOfPathForRunnig = presenceOfPathForRunnig;
  }


  public long getPresenceOfGymnasticZone() {
    return presenceOfGymnasticZone;
  }

  public void setPresenceOfGymnasticZone(long presenceOfGymnasticZone) {
    this.presenceOfGymnasticZone = presenceOfGymnasticZone;
  }

}
