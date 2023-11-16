package mystore.services;

import mystore.config.ApplicationContext;
import mystore.entities.User;

public class UserManagementService {

  private ApplicationContext context;

  {
    context = ApplicationContext.getInstance();
  }

  public void registerUser(User user) {
    context.setUser(user);
  }

  public void signOutUser() {
    context.setUser(null);
  }
}
