package mystore.entities;

public interface User {
  String getName();
  String getPassword();
  Cart getCart();
  String getEmail();
  Order[] getOrders();
  void setPassword(String password);
  void setEmail(String email);
  int getId();
  void addOrder(Order order);
  void emptyCart();
}
