package mystore.menu.impl;

import java.util.Scanner;
import mystore.ApplicationContext.ApplicationContext;
import mystore.Main;
import mystore.menu.Menu;

public class MainMenu implements Menu {

  private String loggedInUser =
    "1. SignUp\n2. SignOut\n3. Products\n4. Cart\n5. Customers\n6. Orders\nEnter the choice: ";
  private String loggedOutUser =
    "1. SignUp\n2. SignIn\n3. Products\n4. Cart\n5. Customers\n6. Orders\nEnter the choice: ";

  private ApplicationContext context;

  {
    context = ApplicationContext.getInstance();
  }

  @Override
  public void menuStart() {
    while (true) {
      printHeader();
      Menu menuToNavigate = null;
      Scanner sc = new Scanner(System.in);
      int choice;
      String userInput = sc.next();
      if (userInput.equals(Main.exit_command)) {
        System.exit(0);
      }
      try {
        choice = Integer.parseInt(userInput);
        if (choice <= 0 || choice >= 7) {
          throw new Exception();
        }
      } catch (Exception e) {
        System.out.println("That's not valid choice");
        continue;
      }
      switch (choice) {
        case 1:
          menuToNavigate = new SignUpMenu();
          break;
        case 2:
          if (context.getLoggedInUser() != null) {
            menuToNavigate = new SignOutMenu();
          } else {
            menuToNavigate = new SignInMenu();
          }
          break;
        case 3:
          menuToNavigate = new ProductCatlog();
          break;
        case 4:
          menuToNavigate = new CheckoutMenu();
          break;
        case 5:
          menuToNavigate = new CustomerList();
          break;
        case 6:
          menuToNavigate = new OrderMenu();
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
      menuToNavigate.menuStart();
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******* Main Menu *******");
    if (context.getLoggedInUser() != null) {
      System.out.println(loggedInUser);
    } else {
      System.out.println(loggedOutUser);
    }
  }
}
