package mystore.config;

import mystore.entities.Cart;
import mystore.entities.User;

public class ApplicationContext {

  private static ApplicationContext instance;
  private User loggedInUser;
  private Cart sessionCart;

  public static ApplicationContext getInstance() {
    if (instance == null) {
      instance = new ApplicationContext();
    }
    return instance;
  }

  public void setUser(User user) {
    if (user == null) {
      return;
    }
    if (sessionCart != null) {
      sessionCart.clear();
    }
    loggedInUser = user;
  }

  public User getLoggedInUser() {
    return loggedInUser;
  }
}
