package mystore.entities.impl;

import mystore.entities.Product;

public class DefaultProduct implements Product {

  private String name;
  private double price;
  private int id;

  public DefaultProduct(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "id = " + id + ", name = " + name + ", price = " + price;
  }
}
