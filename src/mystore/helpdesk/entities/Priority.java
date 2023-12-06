package mystore.helpdesk.entities;

public enum Priority {
  LOW(1),
  MEDIUM(2),
  HIGH(3);

  private int impo;

  private Priority(int impo) {
    this.impo = impo;
  }

  public int getImp() {
    return this.impo;
  }
}
