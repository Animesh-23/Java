package account;

public class Demo {

  public static void main(String[] args) {
    Account account1 = new Account(1, 100.0);
    Account account2 = new Account(2, 1000.0);
    account2.sendMoneyToAccount(account1, 400.0);
    System.out.println(account1.getTransactions());
  }
}
