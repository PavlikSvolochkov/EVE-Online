package ru.tsk.eveonline.logic;

public class CharacterInfo {

    private String characterID;
    private String characterName;
    private String race;
    private String bloodlineID;
    private String bloodline;
    private String ancestryID;
    private String ancestry;
    private String accountBalance;
    private String skillPoints;
    private String nextTrainingEnds;
    private String shipName;
    private String shipTypeID;
    private String shipTypeName;
    private String corporationID;
    private String corporation;
    private String corporationDate;
    private String allianceID;
    private String alliance;
    private String allianceDate;
    private String lastKnownLocation;
    private String securityStatus;

    /**
     * TODO
     * <p>
     * <rowset name="employmentHistory" key="recordID" columns="recordID,corporationID,corporationName,startDate">
     * <row recordID="36393053" corporationID="671798908" corporationName="Strange Energy" startDate="2014-12-22 14:36:00" />
     * <row recordID="10452736" corporationID="1000167" corporationName="State War Academy" startDate="2008-12-20 13:22:00" />
     * </rowset>
     */

    public CharacterInfo() {

    }

    public String getCharacterID() {
        return characterID;
    }

    public void setCharacterID(String characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBloodlineID() {
        return bloodlineID;
    }

    public void setBloodlineID(String bloodlineID) {
        this.bloodlineID = bloodlineID;
    }

    public String getBloodline() {
        return bloodline;
    }

    public void setBloodline(String bloodline) {
        this.bloodline = bloodline;
    }

    public String getAncestryID() {
        return ancestryID;
    }

    public void setAncestryID(String ancestryID) {
        this.ancestryID = ancestryID;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(String skillPoints) {
        this.skillPoints = skillPoints;
    }

    public String getNextTrainingEnds() {
        return nextTrainingEnds;
    }

    public void setNextTrainingEnds(String nextTrainingEnds) {
        this.nextTrainingEnds = nextTrainingEnds;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(String shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public String getShipTypeName() {
        return shipTypeName;
    }

    public void setShipTypeName(String shipTypeName) {
        this.shipTypeName = shipTypeName;
    }

    public String getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(String corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getCorporationDate() {
        return corporationDate;
    }

    public void setCorporationDate(String corporationDate) {
        this.corporationDate = corporationDate;
    }

    public String getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(String allianceID) {
        this.allianceID = allianceID;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

    public String getAllianceDate() {
        return allianceDate;
    }

    public void setAllianceDate(String allianceDate) {
        this.allianceDate = allianceDate;
    }

    public String getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(String lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    @Override
    public String toString() {
        return "CharacterInfo{" +
                "characterID='" + characterID + '\'' +
                ", characterName='" + characterName + '\'' +
                ", race='" + race + '\'' +
                ", bloodlineID='" + bloodlineID + '\'' +
                ", bloodline='" + bloodline + '\'' +
                ", ancestryID='" + ancestryID + '\'' +
                ", ancestry='" + ancestry + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", skillPoints='" + skillPoints + '\'' +
                ", nextTrainingEnds='" + nextTrainingEnds + '\'' +
                ", shipName='" + shipName + '\'' +
                ", shipTypeID='" + shipTypeID + '\'' +
                ", shipTypeName='" + shipTypeName + '\'' +
                ", corporationID='" + corporationID + '\'' +
                ", corporation='" + corporation + '\'' +
                ", corporationDate='" + corporationDate + '\'' +
                ", allianceID='" + allianceID + '\'' +
                ", alliance='" + alliance + '\'' +
                ", allianceDate='" + allianceDate + '\'' +
                ", lastKnownLocation='" + lastKnownLocation + '\'' +
                ", securityStatus='" + securityStatus + '\'' +
                '}';
    }
}
