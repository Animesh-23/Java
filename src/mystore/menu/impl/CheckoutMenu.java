package mystore.menu.impl;

import java.util.Scanner;
import mystore.config.ApplicationContext;
import mystore.menu.Menu;

public class CheckoutMenu implements Menu {

  private ApplicationContext context;

  {
    context = ApplicationContext.getInstance();
  }

  @Override
  public void menuStart() {
    printHeader();
    if (context.getUser() == null) {
      System.out.println("Before ordering first login");
      return;
    } else if (context.getCart() == null) {
      System.out.println("Your cart is empty");
      return;
    } else {
      Scanner sc = new Scanner(System.in);
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******* Chekcout *******");
  }
}
