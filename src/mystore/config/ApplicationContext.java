package mystore.config;

import mystore.entities.Cart;
import mystore.entities.Product;
import mystore.entities.User;
import mystore.entities.impl.DefaultCart;

public class ApplicationContext {

  private static ApplicationContext instance;
  private User loggedInUser;
  private Cart sessionCart;

  {
    sessionCart = new DefaultCart();
  }

  public static ApplicationContext getInstance() {
    if (instance == null) {
      instance = new ApplicationContext();
    }
    return instance;
  }

  public User getUser() {
    return loggedInUser;
  }

  public void setUser(User user) {
    sessionCart.clear();
    this.loggedInUser = user;
    sessionCart = new DefaultCart();
  }

  public void addProduct(Product product) {
    sessionCart.addToCart(product);
  }

  public Cart getCart() {
    return sessionCart;
  }

  public void logOutUser() {
    this.loggedInUser = null;
  }
}
