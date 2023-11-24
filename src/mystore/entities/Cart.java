package mystore.entities;

import java.util.Map;

public interface Cart {
  double getTotalPrice();
  void addProduct(Product product, int quantity);
  void setQuantity(Product product, int quantity);
  Map<Product, Integer> getItems();
}
