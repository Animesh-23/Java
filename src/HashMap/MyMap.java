package HashMap;

public class MyMap<K, V> {

  private static final int bucketSize = 20;
  private int size = 0;
  private Node[] bucket;

  {
    bucket = new Node[bucketSize];
  }

  private int getHashIndex(K key) {
    int hashcode = key.hashCode();
    return hashcode % bucketSize;
  }

  public int size() {
    return size;
  }

  public Object get(K key) {
    int bcIdx = getHashIndex(key);
    Node head = bucket[bcIdx];
    while (head != null) {
      if (head.key.equals(key)) {
        return head.value;
      }
      head = head.next;
    }
    return null;
  }

  public void put(K key, V value) {
    int bcIdx = getHashIndex(key);
    Node head = bucket[bcIdx];
    boolean alreadyPresent = false;
    Node last = null;
    while (head != null) {
      if (head.key.equals(key)) {
        head.value = value;
        alreadyPresent = true;
        break;
      }
      if (head.next == null) {
        last = head;
      }
      head = head.next;
    }
    if (!alreadyPresent) {
      Node node = new Node<K, V>(key, value);
      size++;
      if (last == null) {
        bucket[bcIdx] = node;
      } else {
        last.next = node;
      }
    }
  }

  public void remove(K key) {
    int bcIdx = getHashIndex(key);
    Node head = bucket[bcIdx];
    if (head == null) {
      return;
    }
    if (head.key.equals(key)) {
      bucket[bcIdx] = head.next;
      size--;
      return;
    }
    Node prev = head;
    Node trav = head.next;
    while (trav != null) {
      if (trav.key.equals(key)) {
        prev.next = trav.next;
        size--;
        trav = null;
        return;
      }
      prev = trav;
      trav = trav.next;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < bucketSize; i++) {
      Node trav = bucket[i];
      while (trav != null) {
        sb.append("[");
        sb.append(String.valueOf(trav.key));
        sb.append(",");
        sb.append(String.valueOf(trav.value));
        sb.append("]");
        sb.append(" ");
        trav = trav.next;
      }
    }
    return new String(sb);
  }

  private class Node<K, V> {

    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      next = null;
    }
  }
}
