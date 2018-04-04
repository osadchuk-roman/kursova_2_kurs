package osadchuk.roman.tempModel;


public class SportArena {

  private long id;
  private long sportBuildingId;
  private long capacity;
  private long presenceOfGymnasticZone;
  private long presenceOfBoxingRing;
  private long presenceOfMatirialArtsZone;


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


  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(long capacity) {
    this.capacity = capacity;
  }


  public long getPresenceOfGymnasticZone() {
    return presenceOfGymnasticZone;
  }

  public void setPresenceOfGymnasticZone(long presenceOfGymnasticZone) {
    this.presenceOfGymnasticZone = presenceOfGymnasticZone;
  }


  public long getPresenceOfBoxingRing() {
    return presenceOfBoxingRing;
  }

  public void setPresenceOfBoxingRing(long presenceOfBoxingRing) {
    this.presenceOfBoxingRing = presenceOfBoxingRing;
  }


  public long getPresenceOfMatirialArtsZone() {
    return presenceOfMatirialArtsZone;
  }

  public void setPresenceOfMatirialArtsZone(long presenceOfMatirialArtsZone) {
    this.presenceOfMatirialArtsZone = presenceOfMatirialArtsZone;
  }

}
