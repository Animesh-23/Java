package account;

import java.util.*;

public class Account {

  private int id;
  private List<Transaction> transactions;
  private double money = 0;

  public Account(int id, double money) {
    this.id = id;
    transactions = new ArrayList<>();
    this.money = money;
  }

  public int getId() {
    return id;
  }

  public double getMoney() {
    return money;
  }

  public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
    if (moneyAmount > money) {
      return;
    }
    this.money -= moneyAmount;
    transactions.add(
      new Transaction(
        this,
        accountTo,
        moneyAmount,
        StandardAccountOperation.MONEY_TRANSFER_SEND
      )
    );
    accountTo.receiveMoneyFromAccount(this, moneyAmount);
  }

  public void receiveMoneyFromAccount(Account accountFrom, double moneyAmount) {
    this.money += moneyAmount;
    transactions.add(
      new Transaction(
        accountFrom,
        this,
        moneyAmount,
        StandardAccountOperation.MONEY_TRANSFER_RECEIVE
      )
    );
  }

  public void withdrawMoney(double moneyAmount) {
    if (money == 0 || moneyAmount > money || moneyAmount < 0) {
      return;
    }
    money -= moneyAmount;
    transactions.add(
      new Transaction(this, moneyAmount, StandardAccountOperation.WITHDRAWL)
    );
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  @Override
  public String toString() {
    return "id = " + id;
  }

  public class Transaction {

    private Account accountFrom;
    private Account accountTo;
    private double moneyAmount;
    private StandardAccountOperation operation;

    public Transaction(
      Account accountFrom,
      Account accountTo,
      double moneyAmount,
      StandardAccountOperation operation
    ) {
      this.accountFrom = accountFrom;
      this.accountTo = accountTo;
      this.moneyAmount = moneyAmount;
      this.operation = operation;
    }

    public Transaction(
      Account account,
      double moneyAmount,
      StandardAccountOperation operation
    ) {
      this.accountFrom = account;
      this.moneyAmount = moneyAmount;
      this.operation = operation;
    }

    @Override
    public String toString() {
      if (operation == StandardAccountOperation.WITHDRAWL) {
        return operation + "   , " + accountFrom + " ," + moneyAmount;
      }
      return (
        operation +
        "    , " +
        accountFrom +
        " -> " +
        accountTo +
        ",    " +
        moneyAmount
      );
    }
  }
}
