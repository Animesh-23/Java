package book;

public class Author {

  private int id;
  private String firstName;
  private String lastName;

  public Author(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getName() {
    return firstName + " " + lastName;
  }

  @Override
  public String toString() {
    return "Author id = " + id + ",  name = " + firstName + " " + lastName;
  }
}
