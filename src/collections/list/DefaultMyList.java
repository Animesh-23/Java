package collections.list;

import java.util.Arrays;

public class DefaultMyList<E> implements MyList {

  private int lastIndex = 0;

  private int capacity = 16;
  private Object[] list;

  public DefaultMyList() {
    list = new Object[capacity];
  }

  public DefaultMyList(int capacity) {
    list = new Object[capacity];
    this.capacity = capacity;
  }

  @Override
  public void add(Object e) {
    if (lastIndex == list.length) {
      list = Arrays.copyOf(list, list.length << 1);
    }
    list[lastIndex] = e;
  }

  @Override
  public void clear() {
    lastIndex = 0;
    list = new Object[capacity];
  }

  @Override
  public boolean remove(Object o) {
    if (lastIndex == 0) {
      return false;
    }
    Object[] newList = new Object[lastIndex - 1];
    boolean found = false;
    int idx = 0;
    for (int i = 0; i < lastIndex; i++) {
      if (list[i].equals(o)) {
        found = true;
        continue;
      }
      if (i == lastIndex - 1 && !found) {
        newList = null;
        return false;
      }
      newList[idx++] = list[i];
    }
    list = newList;
    return true;
  }

  @Override
  public Object[] toArray() {
    return list;
  }

  @Override
  public int size() {
    return lastIndex;
  }

  @Override
  public boolean contains(Object o) {
    for (Object e : list) {
      if (e.equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(MyList c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'containsAll'"
    );
  }
}
