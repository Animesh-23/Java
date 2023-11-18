package disjoint;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    DisjointSet set = new DisjointSet(8);
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Enter choice ");
      int choice = sc.nextInt();
      System.out.println("Enter first node ");
      int u = sc.nextInt();
      System.out.println("Enter a second node");
      int v = sc.nextInt();
      if (choice == 0) {
        set.unionBySize(u, v);
      } else if (choice == 99) {
        break; 
      } else {
        System.out.println(set.isConnected(u, v));
      }
    }
  }
}
