package mystore.menu.impl;

import java.util.Arrays;
import java.util.Scanner;
import mystore.config.ApplicationContext;
import mystore.entities.Product;
import mystore.menu.Menu;
import mystore.services.ProductManagementService;

public class ProductCatlog implements Menu {

  private ProductManagementService productContext;
  private static final String MENU_CAMMAND = "menu";
  private static final String CHECKOUT_COMMAND = "checkout";
  private ApplicationContext context;

  {
    productContext = ProductManagementService.getInstance();
    context = ApplicationContext.getInstance();
  }

  @Override
  public void menuStart() {
    Menu menuToNavigate = null;
    printHeader();
    Product[] products = productContext.getProducts();
    System.out.println(Arrays.toString(products));
    while (true) {
      System.out.println(
        "Enter id to add product in cart\nmenu command to go back to mainMenu\ncheckout command for place the order"
      );
      Scanner sc = new Scanner(System.in);
      String userInput = sc.next();
      if (userInput != null && userInput.equalsIgnoreCase(MENU_CAMMAND)) {
        menuToNavigate = new MainMenu();
        break;
      } else if (
        userInput != null && userInput.equalsIgnoreCase(CHECKOUT_COMMAND)
      ) {
        menuToNavigate = new CheckoutMenu();
        break;
      } else {
        int id;
        try {
          id = Integer.parseInt(userInput);
          Product product = productContext.getProductById(id);
          if (product == null) {
            throw new Exception("Exception");
          }
          context.addProduct(product);
        } catch (Exception e) {
          System.out.println("Thats not a valid id");
        }
      }
    }
    menuToNavigate.menuStart();
  }

  @Override
  public void printHeader() {
    System.out.println("******* Products *******");
  }
}
