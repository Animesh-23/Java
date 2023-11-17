package mystore.entities.impl;

import mystore.entities.Product;

public class DefaultProduct implements Product {

  private int id;
  private String productName;
  private double price;

  public DefaultProduct(int id, String productName, double price) {
    this.id = id;
    this.price = price;
    this.productName = productName;
  }

  @Override
  public String getProductName() {
    return productName;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "id = " + id + ", name = " + productName + ", price = " + price;
  }
}
