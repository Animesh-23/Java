package mystore.menu.impl;

import mystore.config.ApplicationContext;
import mystore.menu.Menu;

public class SignOutMenu implements Menu {

  private ApplicationContext context;

  {
    context = ApplicationContext.getInstance();
  }

  @Override
  public void menuStart() {
    printHeader();
    context.setUser(null);
  }

  @Override
  public void printHeader() {
    System.out.println("See you next time");
  }
}
