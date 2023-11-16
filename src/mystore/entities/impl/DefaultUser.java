package mystore.entities.impl;

import mystore.entities.User;

public class DefaultUser implements User {

  private String name;
  private int id;
  private String email;
  private String password;

  public DefaultUser(String name, int id, String email, String password) {
    this.name = name;
    this.id = id;
    this.email = email;
    this.password = password;
  }

  @Override
  public String getUserName() {
    return name;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }
}
