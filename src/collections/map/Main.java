package collections.map;

public class Main {

  public static void main(String[] args) {
    LruCache cache = new DefaultLruCache();
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.put(5, 5);
    cache.put(6, 6);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
    cache.put(7, 7);
    System.out.println(cache.get(3));
  }
}
