package HashMap;

public class Main {

  public static void main(String[] args) {
    MyMap<Integer, Integer> map = new MyMap<>();
    map.put(1, 2);
    map.put(1222, 3);
    map.put(2, 2);
    map.put(1, 8);
    System.out.println(map);
    System.out.println(map.size());
  }
}
