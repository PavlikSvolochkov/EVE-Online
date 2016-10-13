package logic;

public class CorporationTitle {

    private String titleName;
    private String titleId;

    public CorporationTitle() {
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    @Override
    public String toString() {
        return "CorporationTitle{" +
                "titleName='" + titleName + '\'' +
                ", titleId='" + titleId + '\'' +
                '}';
    }
}
