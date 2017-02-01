package ru.tsk.eveonline.logic;

public class AccountCharacter {

    private String name;
    private String characterID;
    private String corporationName;
    private String corporationID;
    private String allianceID;
    private String allianceName;
    private String factionID;
    private String factionName;

    public AccountCharacter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterID() {
        return characterID;
    }

    public void setCharacterID(String characterID) {
        this.characterID = characterID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(String corporationID) {
        this.corporationID = corporationID;
    }

    public String getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(String allianceID) {
        this.allianceID = allianceID;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public String getFactionID() {
        return factionID;
    }

    public void setFactionID(String factionID) {
        this.factionID = factionID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountCharacter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", characterID='").append(characterID).append('\'');
        sb.append(", corporationName='").append(corporationName).append('\'');
        sb.append(", corporationID='").append(corporationID).append('\'');
        sb.append(", allianceID='").append(allianceID).append('\'');
        sb.append(", allianceName='").append(allianceName).append('\'');
        sb.append(", factionID='").append(factionID).append('\'');
        sb.append(", factionName='").append(factionName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
