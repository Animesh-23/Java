package mystore.ApplicationContext;

import mystore.entities.User;

public class ApplicationContext {

  private static ApplicationContext instance;
  private User loggedInUser;

  public static ApplicationContext getInstance() {
    if (instance == null) {
      instance = new ApplicationContext();
    }
    return instance;
  }

  public User gerLoggedInUser() {
    return loggedInUser;
  }

  public void setUser(User user) {
    this.loggedInUser = user;
  }

  public void logOutUser() {
    this.loggedInUser = null;
  }
}
