package mystore.services;

import mystore.entities.Product;
import mystore.entities.impl.DefaultProduct;

public class ProductManagementService {

  private Product[] products;
  public static ProductManagementService instance;

  public static ProductManagementService getInstance() {
    if (instance == null) {
      instance = new ProductManagementService();
    }
    return instance;
  }

  {
    products =
      new Product[] {
        new DefaultProduct(1, "Patanjali 1", 100),
        new DefaultProduct(2, "Patanjali 2", 200),
        new DefaultProduct(3, "Patanjali 3", 300),
        new DefaultProduct(4, "Patanjali 4", 400),
        new DefaultProduct(5, "Patanjali 5", 500),
        new DefaultProduct(6, "Patanjali 6", 600),
        new DefaultProduct(7, "Patanjali 7", 700),
      };
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
