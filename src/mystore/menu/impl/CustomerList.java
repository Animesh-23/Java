package mystore.menu.impl;

import java.util.Arrays;
import java.util.Scanner;
import mystore.entities.User;
import mystore.menu.Menu;
import mystore.services.UserManagementService;

public class CustomerList implements Menu {

  private UserManagementService contextUser;

  {
    contextUser = UserManagementService.getInstance();
  }

  @Override
  public void menuStart() {
    printHeader();
    User[] users = contextUser.getUsers();
    if (users.length == 0) {
      System.out.println("Currently ther are no customers ");
      return;
    }
    System.out.println(Arrays.toString(users));
    Scanner sc = new Scanner(System.in);
    String buff = sc.next();
  }

  @Override
  public void printHeader() {
    System.out.println("******* Customers *******");
  }
}
