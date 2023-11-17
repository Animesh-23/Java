package mystore.entities.impl;

import mystore.entities.User;

public class DefaultUser implements User {

  private int id;
  private String name;
  private String email;
  private String password;

  private static int counter = 0;

  {
    id = ++counter;
  }

  public DefaultUser(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  @Override
  public String getName() {
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
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }
}
