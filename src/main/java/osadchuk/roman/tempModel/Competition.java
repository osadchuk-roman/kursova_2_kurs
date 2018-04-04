package osadchuk.roman.tempModel;



public class Competition {

  private long id;
  private String name;
  private java.sql.Date date;
  private long organizerId;
  private long sportBuildingId;
  private long kindOfSportId;


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


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }


  public long getOrganizerId() {
    return organizerId;
  }

  public void setOrganizerId(long organizerId) {
    this.organizerId = organizerId;
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
