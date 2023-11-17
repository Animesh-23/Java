package mystore.menu.impl;

import java.util.Scanner;
import mystore.Main;
import mystore.config.ApplicationContext;
import mystore.menu.Menu;

public class MainMenu implements Menu {

  private ApplicationContext context;

  {
    context = ApplicationContext.getInstance();
  }

  private String MENU_USER_LOGGED_IN =
    "1. Sign Up\n2. Sign Out\n3. Product\n4. Cart\n5. Customers\n";
  private String MENU_USER_LOGGED_OUT =
    "1. Sign Up\n2. Sign In\n3. Product\n4. Cart\n5. Customers\n";

  @Override
  public void menuStart() {
    while (true) {
      printHeader();
      Menu menuToNavigate = null;
      mainloop:while (true) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        if (userInput.equalsIgnoreCase(Main.EXIT_COMMAND)) {
          System.exit(0);
        } else {
          int choice;
          try {
            choice = Integer.parseInt(userInput);
            if (choice > 5 || choice < 1) {
              throw new Exception(" hello");
            }
          } catch (Exception e) {
            System.out.println("Enter the valid input");
            break mainloop;
          }
          switch (choice) {
            case 1:
              menuToNavigate = new SignUpMenu();
              break mainloop;
            case 2:
              if (context.getUser() == null) {
                menuToNavigate = new SignInMenu();
              } else {
                menuToNavigate = new SignOutMenu();
              }
              break mainloop;
            case 3:
              menuToNavigate = new ProductCatlog();
              break mainloop;
          }
        }
      }
      menuToNavigate.menuStart();
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******** Main Menu **********");
    if (context.getUser() == null) {
      System.out.println(MENU_USER_LOGGED_OUT);
    } else {
      System.out.println(MENU_USER_LOGGED_IN);
    }
  }
}
