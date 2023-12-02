package collections.list;

public class Main {

  public static void main(String[] args) {
    MyList<Integer> list = new DefaultMyList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    System.out.println(list.contains(1));
  }
}
