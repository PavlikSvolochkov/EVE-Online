package logic;

public class AccountStatus {

    /**
     * <result>
     * <paidUntil>2015-06-27 10:20:57</paidUntil>
     * <createDate>2007-05-04 17:47:00</createDate>
     * <logonCount>3177</logonCount>
     * <logonMinutes>235243</logonMinutes>
     * <rowset name="multiCharacterTraining" key="trainingEnd" columns="trainingEnd" />
     * </result>
     */

    private String paidUntil;
    private String createDate;
    private String logonCount;
    private String logonMinutes;

    public AccountStatus() {
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
        final StringBuilder sb = new StringBuilder("AccountStatus{");
        sb.append("paidUntil='").append(paidUntil).append('\'');
        sb.append(", createDate='").append(createDate).append('\'');
        sb.append(", logonCount='").append(logonCount).append('\'');
        sb.append(", logonMinutes='").append(logonMinutes).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
