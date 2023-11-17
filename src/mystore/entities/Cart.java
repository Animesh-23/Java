package mystore.entities;

public interface Cart {
  void addToCart(Product product);
  Product[] geProducts();
  void clear();
}
