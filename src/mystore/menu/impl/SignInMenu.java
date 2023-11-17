package mystore.menu.impl;

import java.util.Scanner;
import mystore.config.ApplicationContext;
import mystore.entities.User;
import mystore.menu.Menu;
import mystore.services.UserManagementService;

public class SignInMenu implements Menu {

  private ApplicationContext context;
  private UserManagementService userContext;

  {
    context = ApplicationContext.getInstance();
    userContext = UserManagementService.getInstance();
  }

  @Override
  public void menuStart() {
    printHeader();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter you email ");
    String email = sc.next();
    System.out.println("Enter the password");
    String password = sc.next();
    User user = userContext.getUser(email, password);
    if (user == null) {
      System.out.println("Enter correct credentials");
    } else {
      context.setUser(user);
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******* Sign In *******");
  }
}
