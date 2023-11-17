package mystore.entities;

public interface User {
  String getName();
  int getId();
  String getEmail();
  void setEmail(String email);
  String getPassword();
  void setPassword(String password);
}
