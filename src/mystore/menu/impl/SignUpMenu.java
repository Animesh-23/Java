package mystore.menu.impl;

import java.util.Scanner;
import mystore.ApplicationContext.ApplicationContext;
import mystore.menu.Menu;
import mystore.services.UserManagementService;

public class SignUpMenu implements Menu {

  private ApplicationContext contextApp;
  private UserManagementService contextUser;

  @Override
  public void menuStart() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter you name ");
    String name = sc.next();
    System.out.println("Enter email ");
    String email = sc.next();
    System.out.println("Enter password");
    String password = sc.next();
  }

  @Override
  public void printHeader() {
    System.out.println("******* Sign Up ********");
  }
}
