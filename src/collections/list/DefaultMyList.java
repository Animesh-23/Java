package collections.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList implements MyList, ListIterable {

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
    Object[] array = c.toArray();
    for (int i = 0; i < array.length; i++) {
      if (!contains(array[i])) {
        return false;
      }
    }
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

  @Override
  public Iterator<Object> iterator() {
    Iterator<Object> iterator = new IteratorImpl(head);

    return iterator;
  }

  private class IteratorImpl implements Iterator<Object> {

    Node curr;
    Node lastNode;

    public IteratorImpl(Node head) {
      curr = head;
      lastNode = null;
    }

    public IteratorImpl() {}

    public boolean hasNext() {
      return curr != null;
    }

    public Object next() {
      if (curr == null) {
        throw new NoSuchElementException();
      }
      Node node = curr;
      lastNode = node;
      curr = curr.next;
      return node.val;
    }

    public void remove() {
      if (lastNode == null) {
        throw new IllegalStateException();
      }
      DefaultMyList.this.remove(lastNode.val);
      lastNode = null;
    }
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

  private class ListIteratorImpl extends IteratorImpl implements ListIterator {

    public ListIteratorImpl(Node head) {
      curr = head;
      lastNode = null;
    }

    @Override
    public boolean hasPrevious() {
      return curr.prev != null;
    }

    @Override
    public Object previous() {
      if (curr == null || curr.prev == null) {
        throw new NoSuchElementException();
      }
      Node node = curr.prev;
      lastNode = node;
      curr = curr.prev;

      return node.val;
    }

    @Override
    public void set(Object e) {
      if (lastNode == null) {
        throw new IllegalStateException();
      }
      lastNode.val = e;
      lastNode = null;
    }
  }

  @Override
  public ListIterator listIterator() {
    return new ListIteratorImpl(head);
  }
}
