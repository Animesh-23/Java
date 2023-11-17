package mystore.services;

import mystore.entities.Product;
import mystore.entities.impl.DefaultProduct;

public class ProductManagementService {

  private Product[] products;
  private static ProductManagementService instance;
  private int lastIdx = 0;

  {
    products =
      new Product[] {
        new DefaultProduct(1, "Patanjaali ", 100.0),
        new DefaultProduct(2, "Patanjaali2", 200.0),
        new DefaultProduct(3, "Patanjaai 3", 300.0),
        new DefaultProduct(4, "Patanjaali4", 400.0),
        new DefaultProduct(5, "Patanjaali5", 500.0),
        new DefaultProduct(6, "Patanjaali6", 600.0),
        new DefaultProduct(7, "Patanjaali7", 700.0),
      };
  }

  public static ProductManagementService getInstance() {
    if (instance == null) {
      instance = new ProductManagementService();
    }
    return instance;
  }

  public Product[] getProducts() {
    return products;
  }

  public Product getProductById(int id) {
    for (Product product : products) {
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }
}
