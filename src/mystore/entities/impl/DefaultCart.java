package mystore.entities.impl;

import java.util.Arrays;
import mystore.entities.Cart;
import mystore.entities.Product;

public class DefaultCart implements Cart {

  private Product[] products;
  private static int CART_DEFAULT_CAPACITY = 20;
  private int lastIndex = 0;

  {
    products = new Product[CART_DEFAULT_CAPACITY];
  }

  @Override
  public void addToCart(Product product) {
    if (lastIndex >= products.length) {
      products = Arrays.copyOf(products, products.length << 1);
    }
    products[lastIndex++] = product;
  }

  @Override
  public Product[] geProducts() {
    return products;
  }

  public void clear() {
    products = new Product[CART_DEFAULT_CAPACITY];
  }
}
