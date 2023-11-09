package book;

public class Publisher {

  private int id;
  private String publisherName;

  public Publisher(int id, String publisherName) {
    this.id = id;
    this.publisherName = publisherName;
  }

  public int getId() {
    return id;
  }

  public String getPublisherName() {
    return publisherName;
  }

  @Override
  public String toString() {
    return "Publisher id = " + id + ", name = " + publisherName;
  }
}
