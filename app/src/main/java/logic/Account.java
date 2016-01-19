package logic;

public class Account {

  private String paidUntil;
  private String createDate;
  private String logonCount;
  private String logonMinutes;

  public Account() {

  }

  public String getPaidUntil() {
    return paidUntil;
  }

  public void setPaidUntil(String paidUntil) {
    this.paidUntil = paidUntil;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getLogonCount() {
    return logonCount;
  }

  public void setLogonCount(String logonCount) {
    this.logonCount = logonCount;
  }

  public String getLogonMinutes() {
    return logonMinutes;
  }

  public void setLogonMinutes(String logonMinutes) {
    this.logonMinutes = logonMinutes;
  }

  @Override
  public String toString() {
    return "Account{" +
            "paidUntil='" + paidUntil + '\'' +
            ", createDate='" + createDate + '\'' +
            ", logonCount='" + logonCount + '\'' +
            ", logonMinutes='" + logonMinutes + '\'' +
            '}';
  }
}
