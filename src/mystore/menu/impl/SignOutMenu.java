package mystore.menu.impl;

import mystore.ApplicationContext.ApplicationContext;
import mystore.menu.Menu;

public class SignOutMenu implements Menu {

  private ApplicationContext context;

  {
    context = ApplicationContext.getInstance();
  }

  @Override
  public void menuStart() {
    printHeader();
    System.out.println("See you again " + context.getLoggedInUser().getName());
    context.logOutUser();
  }

  @Override
  public void printHeader() {
    System.out.println("******* Sign Out *******");
  }
}
