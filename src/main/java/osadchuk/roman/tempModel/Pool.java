package osadchuk.roman.tempModel;



public class Pool {

  private long id;
  private long sportBuildingId;
  private long depth;
  private long width;
  private long length;
  private long maxHeight;


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


  public long getDepth() {
    return depth;
  }

  public void setDepth(long depth) {
    this.depth = depth;
  }


  public long getWidth() {
    return width;
  }

  public void setWidth(long width) {
    this.width = width;
  }


  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }


  public long getMaxHeight() {
    return maxHeight;
  }

  public void setMaxHeight(long maxHeight) {
    this.maxHeight = maxHeight;
  }

}
