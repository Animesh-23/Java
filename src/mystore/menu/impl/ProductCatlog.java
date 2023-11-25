package mystore.menu.impl;

import java.util.Arrays;
import java.util.Scanner;
import mystore.ApplicationContext.ApplicationContext;
import mystore.entities.Cart;
import mystore.entities.Product;
import mystore.entities.User;
import mystore.menu.Menu;
import mystore.services.ProductManagementService;

public class ProductCatlog implements Menu {

  private ApplicationContext contextApp;
  private ProductManagementService contextProduct;

  {
    contextApp = ApplicationContext.getInstance();
    contextProduct = ProductManagementService.getInstance();
  }

  @Override
  public void menuStart() {
    while (true) {
      printHeader();
      Scanner sc = new Scanner(System.in);
      User user = contextApp.getLoggedInUser();
      System.out.println(
        "If you want to add the product to cart enter product Id or going back enter \'back\'"
      );
      String userInput = sc.next();
      if (user == null) {
        System.out.println("You need to login first");
        break;
      }
      if (userInput.equals("back")) {
        break;
      }
      int id;
      Product product;
      try {
        id = Integer.parseInt(userInput);
        product = contextProduct.getProductById(id);
        if (product == null) {
          throw new Exception();
        }
      } catch (Exception e) {
        System.out.println("Invalid Id ");
        continue;
      }
      int quantity = -1;
      while (true) {
        System.out.println("How many items do you want to buy enter quantity ");
        try {
          quantity = sc.nextInt();
          if (quantity < 1) {
            throw new Exception();
          }
          break;
        } catch (Exception e) {
          System.out.println("Enter valid input ");
          System.out.println("Or for going back enter \'back\'");
          String choice = sc.next();
          if (choice.equals("back")) {
            quantity = -1;
            break;
          }
        }
      }
      if (quantity == -1) {
        continue;
      }
      Cart cart = user.getCart();
      cart.addProduct(product, quantity);
    }
  }

  @Override
  public void printHeader() {
    System.out.println("******* Products *******");
    System.out.println(Arrays.toString(contextProduct.getProducts()));
  }
}
