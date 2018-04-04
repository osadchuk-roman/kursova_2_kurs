package osadchuk.roman.tempModel;



public class Gym {

  private long id;
  private long sportBuildingId;
  private long presenceOfCardioZone;
  private long presenceOfCrossfitZone;
  private long presenceOfBoxingRing;


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


  public long getPresenceOfCardioZone() {
    return presenceOfCardioZone;
  }

  public void setPresenceOfCardioZone(long presenceOfCardioZone) {
    this.presenceOfCardioZone = presenceOfCardioZone;
  }


  public long getPresenceOfCrossfitZone() {
    return presenceOfCrossfitZone;
  }

  public void setPresenceOfCrossfitZone(long presenceOfCrossfitZone) {
    this.presenceOfCrossfitZone = presenceOfCrossfitZone;
  }


  public long getPresenceOfBoxingRing() {
    return presenceOfBoxingRing;
  }

  public void setPresenceOfBoxingRing(long presenceOfBoxingRing) {
    this.presenceOfBoxingRing = presenceOfBoxingRing;
  }

}
