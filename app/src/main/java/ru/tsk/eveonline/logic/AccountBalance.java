package ru.tsk.eveonline.logic;

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
        final StringBuilder sb = new StringBuilder("AccountBalance{");
        sb.append("accountID='").append(accountID).append('\'');
        sb.append(", accountKey='").append(accountKey).append('\'');
        sb.append(", balance='").append(balance).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
