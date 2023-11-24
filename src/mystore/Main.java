package mystore;

import mystore.menu.Menu;
import mystore.menu.impl.MainMenu;

public class Main {

  public static final String exit_command = "exit";

  public static void main(String[] args) {
    Menu menu = new MainMenu();
    menu.menuStart();
  }
}
