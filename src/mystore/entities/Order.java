package mystore.entities;

import java.util.Map;

public interface Order {
  String getDateAndTime();
  String getAccountNumber();
  Map<Product, Integer> getItems();
  double getTotalPrice();
}
