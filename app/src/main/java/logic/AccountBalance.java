package logic;

public class AccountBalance {

  private String accountID;
  private String accountKey;
  private String balance;

  public AccountBalance() {
  }

  public String getAccountID() {
    return accountID;
  }

  public void setAccountID(String accountID) {
    this.accountID = accountID;
  }

  public String getAccountKey() {
    return accountKey;
  }

  public void setAccountKey(String accountKey) {
    this.accountKey = accountKey;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "AccountBalance{" +
            "accountID='" + accountID + '\'' +
            ", accountKey='" + accountKey + '\'' +
            ", balance='" + balance + '\'' +
            '}';
  }
}
