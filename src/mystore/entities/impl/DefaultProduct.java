package mystore.entities.impl;

import mystore.entities.Product;

public class DefaultProduct implements Product {

  private int id;
  private String name;
  private double price;

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
  public int getId() {
    return id;
  }

  @Override
  public double getPrice() {
    return price;
  }
}
