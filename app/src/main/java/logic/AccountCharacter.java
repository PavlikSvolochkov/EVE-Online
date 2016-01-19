package logic;

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
    return "AccountCharacter{" +
            "name='" + name + '\'' +
            ", characterID='" + characterID + '\'' +
            ", corporationName='" + corporationName + '\'' +
            ", corporationID='" + corporationID + '\'' +
            ", allianceID='" + allianceID + '\'' +
            ", allianceName='" + allianceName + '\'' +
            ", factionID='" + factionID + '\'' +
            ", factionName='" + factionName + '\'' +
            '}';
  }
}
