package sweet;

public class Demo {

  public static void main(String[] args) {
    Present present = new Present();
    present.addSweet(new Candy("choopachoops", 110, 80));
    System.out.println(present.getSweets());
  }
}
