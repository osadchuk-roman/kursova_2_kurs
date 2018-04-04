package osadchuk.roman.tempModel;



public class Court {

  private long id;
  private long sportBuildingId;
  private long typeOfCoverId;
  private double width;
  private double length;


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


  public long getTypeOfCoverId() {
    return typeOfCoverId;
  }

  public void setTypeOfCoverId(long typeOfCoverId) {
    this.typeOfCoverId = typeOfCoverId;
  }


  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }


  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

}
