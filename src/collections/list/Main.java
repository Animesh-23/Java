package collections.list;

import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    DefaultMyList list = new DefaultMyList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    ListIterator iter = list.listIterator();
    System.out.println(iter.next());
    System.out.println(iter.previous());
    System.out.println(iter.next());
  }
}
