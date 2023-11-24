package mystore.entities.impl;

import java.util.HashMap;
import java.util.Map;
import mystore.entities.Cart;
import mystore.entities.Product;

public class DefaultCart implements Cart {

  private Map<Product, Integer> items;

  private double totalPrice = 0;

  public DefaultCart() {
    items = new HashMap<>();
  }

  @Override
  public double getTotalPrice() {
    return totalPrice;
  }

  @Override
  public void addProduct(Product product, int quantity) {
    totalPrice += (product.getPrice() * quantity);
    items.put(product, quantity);
  }

  @Override
  public void setQuantity(Product product, int quantity) {
    if (items.containsKey(product)) {
      totalPrice -= (items.get(product) * product.getPrice());
    }
    totalPrice += (product.getPrice() * quantity);
    items.put(product, quantity);
  }

  @Override
  public Map<Product, Integer> getItems() {
    return items;
  }
}
