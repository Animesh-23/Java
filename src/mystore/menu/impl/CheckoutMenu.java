package mystore.menu.impl;

import java.util.Map;
import java.util.Scanner;
import mystore.ApplicationContext.ApplicationContext;
import mystore.entities.Cart;
import mystore.entities.Order;
import mystore.entities.Product;
import mystore.entities.User;
import mystore.entities.impl.DefaultCart;
import mystore.entities.impl.DefaultOrder;
import mystore.menu.Menu;

public class CheckoutMenu implements Menu {

  private ApplicationContext context;

  {
    context = ApplicationContext.getInstance();
  }

  @Override
  public void menuStart() {
    printHeader();
    while (true) {
      User user = context.getLoggedInUser();
      if (user == null) {
        System.out.println("First login");
        return;
      }
      Cart cart = user.getCart();
      Map<Product, Integer> items = cart.getItems();
      if (items.size() == 0) {
        System.out.println("Your cart is Empty");
        return;
      }
      for (Product product : items.keySet()) {
        System.out.println("Product = [" + product + "]");
        System.out.println("Quantity = " + items.get(product));
        System.out.println();
      }
      System.out.println("Total Cost Is " + cart.getTotalPrice());
      System.out.println(
        "checkout command \'checkout\'\nback command \'back\'"
      );
      Scanner sc = new Scanner(System.in);
      String command = sc.next();
      if (command.equals("checkout")) {
        System.out.println("Enter your account number ");
        String accountNumber = sc.next();
        Order order = new DefaultOrder(
          accountNumber,
          items,
          cart.getTotalPrice()
        );
        user.addOrder(order);
        user.emptyCart();
        System.out.println("Thanks for shopping");
        return;
      } else if (command.equals("back")) {
        return;
      }
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******* Cart *******");
  }
}
