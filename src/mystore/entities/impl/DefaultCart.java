package mystore.entities.impl;

import java.util.Arrays;
import mystore.entities.Cart;
import mystore.entities.Product;

public class DefaultCart implements Cart {

  private static final int DEFAULT_CART_CAPACITY = 10;

  {
    products = new Product[DEFAULT_CART_CAPACITY];
  }

  private Product[] products;
  private int lastIndex;

  @Override
  public Product[] geProducts() {
    Product[] requestedProducts = Arrays.copyOf(products, products.length);
    return requestedProducts;
  }

  @Override
  public void addProduct(Product product) {
    if (product == null) {
      return;
    }
    if (lastIndex >= products.length) {
      products = Arrays.copyOf(products, products.length << 1);
    }
    products[lastIndex++] = product;
  }

  @Override
  public void clear() {
    products = new Product[DEFAULT_CART_CAPACITY];
    lastIndex = 0;
  }
}
