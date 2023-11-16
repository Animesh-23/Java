package mystore.entities;

public interface Cart {
  public Product[] geProducts();

  public void addProduct(Product product);

  public void clear();
}
