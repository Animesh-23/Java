package book;

import java.math.BigDecimal;

public class Book {

  private int id;
  private String name;
  private Author[] authors;
  private Publisher publisher;
  private int publishingYear;
  private int amountOfPages;
  BigDecimal price;
  CoverType coverType;

  public Book(
    int id,
    String name,
    Author[] authors,
    Publisher publisher,
    int publishingYear,
    int amountOfPages,
    BigDecimal price,
    CoverType coverType
  ) {
    this.id = id;
    this.name = name;
    this.authors = authors;
    this.publisher = publisher;
    this.publishingYear = publishingYear;
    this.amountOfPages = amountOfPages;
    this.price = price;
    this.coverType = coverType;
  }

  public int getPublishingYear() {
    return publishingYear;
  }

  public boolean hasAuthor(Author author) {
    for (Author bookAuthor : authors) {
      if (bookAuthor.equals(author)) {
        return true;
      }
    }
    return false;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  @Override
  public String toString() {
    return (
      "Book id = " +
      id +
      ", name = " +
      name +
      ", authors = " +
      authors +
      ", publisher = " +
      publisher +
      ", publishing year = " +
      publishingYear +
      ", pages = " +
      amountOfPages +
      ", price = " +
      price
    );
  }
}
