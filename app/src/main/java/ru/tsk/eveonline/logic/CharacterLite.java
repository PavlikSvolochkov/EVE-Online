package ru.tsk.eveonline.logic;

public class CharacterLite {

    private String characterID;
    private String characterName;
    private String corporationID;
    private String corporationName;
    private String allianceID;
    private String allianceName;
    private String factionID;
    private String factionName;

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

    public String getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(String corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
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
        return "CharacterLite{" +
                "characterID='" + characterID + '\'' +
                ", characterName='" + characterName + '\'' +
                ", corporationID='" + corporationID + '\'' +
                ", corporationName='" + corporationName + '\'' +
                ", allianceID='" + allianceID + '\'' +
                ", allianceName='" + allianceName + '\'' +
                ", factionID='" + factionID + '\'' +
                ", factionName='" + factionName + '\'' +
                '}';
    }
}
