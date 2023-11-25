package mystore.entities.impl;

import java.util.Arrays;
import mystore.entities.Cart;
import mystore.entities.Order;
import mystore.entities.User;

public class DefaultUser implements User {

  private int id;
  private String name;
  private String password;
  private Cart cart;
  private Order[] orders;
  private String email;
  private final int DEFAULT_ORDER_CAPACITY = 10;
  private static int counter = 0;
  private int lastIndex = 0;

  {
    id = ++counter;
  }

  public DefaultUser(String name, String email, String password) {
    this.name = name;
    this.password = password;
    this.email = email;
    orders = new Order[DEFAULT_ORDER_CAPACITY];
    cart = new DefaultCart();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Cart getCart() {
    return cart;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public Order[] getOrders() {
    return orders;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "[id = " + id + ", name = " + name + ", email = " + email + "]";
  }

  @Override
  public void addOrder(Order order) {
    if (lastIndex >= orders.length) {
      orders = Arrays.copyOf(orders, orders.length << 1);
    }
    orders[lastIndex++] = order;
  }

  @Override
  public void emptyCart() {
    cart = new DefaultCart();
  }
}
