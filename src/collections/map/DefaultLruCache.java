package collections.map;

import java.util.LinkedHashMap;

public class DefaultLruCache
  extends LinkedHashMap<Integer, Integer>
  implements LruCache {

  private LinkedHashMap<Integer, Integer> map;
  private int capacity;

  public DefaultLruCache() {
    capacity = 6;
    map = new LinkedHashMap<>();
  }

  @Override
  public int get(int key) {
    if (map.containsKey(key)) {
      map.putLast(key, map.get(key));
      return map.get(key);
    }
    return -1;
  }

  private void removeLru() {
    while (map.size() > capacity) {
      map.pollFirstEntry();
    }
  }

  @Override
  public void put(int key, int value) {
    map.putLast(key, value);
    removeLru();
  }

  @Override
  public void setCapacity(int capacity) {
    this.capacity = capacity;
    removeLru();
  }
}
