package mystore.menu.impl;

import java.util.Scanner;
import mystore.ApplicationContext.ApplicationContext;
import mystore.entities.User;
import mystore.entities.impl.DefaultUser;
import mystore.menu.Menu;
import mystore.services.UserManagementService;

public class SignUpMenu implements Menu {

  private ApplicationContext contextApp;
  private UserManagementService contextUser;

  {
    contextApp = ApplicationContext.getInstance();
    contextUser = UserManagementService.getInstance();
  }

  @Override
  public void menuStart() {
    while (true) {
      printHeader();
      Scanner sc = new Scanner(System.in);
      System.out.println("For going back to main menu type \'back\'");
      String choice = sc.next();
      if (choice.equalsIgnoreCase("back")) {
        return;
      }
      System.out.println("Enter you name ");
      String name = sc.next();
      System.out.println("Enter email ");
      String email = sc.next();
      System.out.println("Enter password ");
      String password = sc.next();
      String error = contextUser.checkEmail(email);
      if (error != null && !error.isEmpty()) {
        System.out.println(error);
        continue;
      }
      User user = new DefaultUser(name, email, password);
      contextUser.addUser(user);
      contextApp.setUser(user);
      break;
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******* Sign Up ********");
  }
}
