package collections.list;

public class DefaultMyList implements MyList {

  private Node head;
  private Node tail;
  private int size;

  public DefaultMyList() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public void add(Object e) {
    Node node = new Node(e);
    size++;
    if (head == null) {
      head = node;
      head.prev = null;
      head.next = null;
      tail = head;
    } else {
      node.prev = tail;
      node.next = null;
      tail.next = node;
      tail = node;
    }
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public boolean remove(Object o) {
    Node trav = head;
    if (head.val.equals(o)) {
      if (head.next == null) {
        clear();
      } else {
        head = head.next;
        head.prev = null;
      }
      size--;
    }
    Node prev = head;
    trav = trav.next;
    while (trav != null) {
      if (trav.val.equals(o)) {
        if (trav.next == null) {
          prev.next = null;
        } else {
          prev.next = trav.next;
          trav.next.prev = prev;
        }
        size--;
        return true;
      }
      prev = prev.next;
      trav = trav.next;
    }
    return false;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node trav = head;
    int idx = 0;
    while (trav != null) {
      arr[idx++] = trav.val;
      trav = trav.next;
    }
    return arr;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(Object o) {
    Node trav = head;
    while (trav != null) {
      if (trav.val.equals(o)) {
        return true;
      }
      trav = trav.next;
    }
    return false;
  }

  @Override
  public boolean containsAll(MyList c) {
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    Node trav = head;
    while (trav != null) {
      sb.append(trav.val);
      trav = trav.next;
      if (trav != null) {
        sb.append(",");
      }
    }
    sb.append("]");
    return String.valueOf(sb);
  }

  private class Node {

    private Node prev;
    private Node next;
    private Object val;

    public Node(Object val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return val + "";
    }
  }
}
