package collections.list;

import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    MyList list = new DefaultMyList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    Iterator itr = list.iterator();
    System.out.println(itr.next());
    System.out.println(itr.next());
    itr.remove();
    itr.remove();
    System.out.println(itr.next());
    for (Object o : list) {
      System.out.println(o);
    }
  }
}
