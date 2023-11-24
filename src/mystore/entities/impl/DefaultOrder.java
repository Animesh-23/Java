package mystore.entities.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import mystore.entities.Order;
import mystore.entities.Product;

public class DefaultOrder implements Order {

  private String dateAndTime;
  private String accountNumber;
  private Map<Product, Integer> items;
  private double totalPrice;

  public DefaultOrder(
    String accountNumber,
    Map<Product, Integer> items,
    double totalPrice
  ) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern(
      "dd-MM-yyyy HH:mm:ss"
    );
    this.accountNumber = accountNumber;
    this.items = items;
    this.totalPrice = totalPrice;
    dateAndTime = now.format(format);
  }

  @Override
  public String getDateAndTime() {
    return dateAndTime;
  }

  @Override
  public String getAccountNumber() {
    return accountNumber;
  }

  @Override
  public Map<Product, Integer> getItems() {
    return items;
  }

  @Override
  public double getTotalPrice() {
    return totalPrice;
  }

  @Override
  public String toString() {
    return (
      "AccountNumber = " +
      accountNumber +
      ", totalPrice = " +
      totalPrice +
      ", date and time = " +
      dateAndTime +
      ", items = " +
      items
    );
  }
}
