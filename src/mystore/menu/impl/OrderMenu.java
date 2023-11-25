package mystore.menu.impl;

import java.util.Arrays;
import mystore.ApplicationContext.ApplicationContext;
import mystore.entities.User;
import mystore.menu.Menu;

public class OrderMenu implements Menu {

  private ApplicationContext context;
  User user;

  {
    context = ApplicationContext.getInstance();
    user = context.getLoggedInUser();
  }

  @Override
  public void menuStart() {
    if (user == null) {
      System.out.println("Login first");
      return;
    }
    System.out.println(Arrays.toString(user.getOrders()));
  }

  @Override
  public void printHeader() {
    System.out.println("******* Orders *******");
  }
}
