package HashMap;

public class Main {

  public static void main(String[] args) {
    MyMap<Integer, Integer> map = new MyMap<>();
    map.put(1, 2);
    map.put(1222, 3);
    map.put(122, 2);
    map.put(12, 2);
    map.put(13, 2);
    map.put(13, 2);
    map.put(2, 2);
    map.put(1, 8);
    System.out.println(map);
    map.remove(1222);
    System.out.println(map);
  }
}
