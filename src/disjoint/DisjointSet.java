package disjoint;

public class DisjointSet {

  private int[] parent;
  private int[] size;

  public DisjointSet(int vertices) {
    parent = new int[vertices + 1];
    size = new int[vertices + 1];
    fillParent();
  }

  private void fillParent() {
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int findParent(int u) {
    if (parent[u] == u) {
      return u;
    }
    parent[u] = findParent(parent[u]);
    return parent[u];
  }

  public boolean isConnected(int u, int v) {
    int pu = findParent(u);
    int pv = findParent(v);
    return pu == pv;
  }

  public void union(int u, int v) {
    int pu = findParent(u);
    int pv = findParent(v);
    if (size[pu] == size[pv]) {
      parent[pv] = parent[pu];
      size[pu] += size[pv];
    } else if (size[pu] > size[pv]) {
      parent[pv] = parent[pu];
      size[pu] += size[pv];
    } else {
      parent[pu] = parent[pv];
      size[pv] += size[pu];
    }
  }
}
