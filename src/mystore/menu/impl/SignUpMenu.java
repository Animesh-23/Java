package mystore.menu.impl;

import java.util.Scanner;
import mystore.config.ApplicationContext;
import mystore.entities.User;
import mystore.entities.impl.DefaultUser;
import mystore.menu.Menu;
import mystore.services.UserManagementService;

public class SignUpMenu implements Menu {

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
    System.out.println("Enter your name ");
    String name = sc.next();
    System.out.println("Enter email ");
    String email = sc.next();
    System.out.println("Enter password");
    String password = sc.next();
    String errorMsg = userContext.chekcEmail(email);
    if (errorMsg == null || errorMsg.isEmpty()) {
      User user = new DefaultUser(name, email, password);
      userContext.addUser(user);
    } else {
      System.out.println(errorMsg);
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******* Sign Up *******");
  }
}
