package osadchuk.roman.tempModel;



public class KindOfSport {

  private long id;
  private String name;

  public KindOfSport(long id) {
    this.id = id;
  }

  public KindOfSport(long id, String name) {

    this.id = id;
    this.name = name;
  }

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

}
