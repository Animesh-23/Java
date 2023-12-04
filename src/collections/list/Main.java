package collections.list;

public class Main {

  public static void main(String[] args) {
    MyList list = new DefaultMyList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    list.remove(4);
    System.out.println(list.size());
  }
}
