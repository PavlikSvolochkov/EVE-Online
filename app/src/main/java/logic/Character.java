package logic;

import java.util.List;

public class Character {

    private String characterId;
    private String name;
    private String homeStationId;
    private String DoB;
    private String race;
    private String bloodlineId;
    private String bloodline;
    private String ancestryID;
    private String ancestry;
    private String gender;
    private String corporationID;
    private String corporationName;
    private String allianceName;
    private String allianceId;
    private String factionName;
    private String factionId;
    private String cloneTypeId;
    private String cloneName;
    private String cloneSkillPoints;
    private String freeSkillPoints;
    private String freeRespecs;
    private String cloneJumpDate;
    private String lastRespecDate;
    private String lastTimeRespec;
    private String remoteStationDate;
    private String cachedUntil;

    private List<JumpClone> jumpClones;
    private List<JumpCloneImplant> jumpCloneImplants;

    private String jumpActivation;
    private String jumpFatigue;
    private String jumpLastUpdate;
    private String balance;

    private List<Implant> implants;

    private List<Attribute> attributes;

    private List<Skill> skills;
    private List<Certificate> certificates;
    private List<CorporationRole> corporationRoles;
    private List<CorporationRoleAtHQ> corporationRolesAtHQ;
    private List<CorporationRoleAtBase> corporationRolesAtBase;
    private List<CorporationRoleAtOther> corporationRolesAtOther;
    private List<CorporationTitle> corporationTitles;

    public Character() {
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeStationId() {
        return homeStationId;
    }

    public void setHomeStationId(String homeStationId) {
        this.homeStationId = homeStationId;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBloodlineId() {
        return bloodlineId;
    }

    public void setBloodlineId(String bloodlineId) {
        this.bloodlineId = bloodlineId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public String getAllianceId() {
        return allianceId;
    }

    public void setAllianceId(String allianceId) {
        this.allianceId = allianceId;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionId() {
        return factionId;
    }

    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }

    public String getCloneTypeId() {
        return cloneTypeId;
    }

    public void setCloneTypeId(String cloneTypeId) {
        this.cloneTypeId = cloneTypeId;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneSkillPoints() {
        return cloneSkillPoints;
    }

    public void setCloneSkillPoints(String cloneSkillPoints) {
        this.cloneSkillPoints = cloneSkillPoints;
    }

    public String getFreeSkillPoints() {
        return freeSkillPoints;
    }

    public void setFreeSkillPoints(String freeSkillPoints) {
        this.freeSkillPoints = freeSkillPoints;
    }

    public String getFreeRespecs() {
        return freeRespecs;
    }

    public void setFreeRespecs(String freeRespecs) {
        this.freeRespecs = freeRespecs;
    }

    public String getCloneJumpDate() {
        return cloneJumpDate;
    }

    public void setCloneJumpDate(String cloneJumpDate) {
        this.cloneJumpDate = cloneJumpDate;
    }

    public String getLastRespecDate() {
        return lastRespecDate;
    }

    public void setLastRespecDate(String lastRespecDate) {
        this.lastRespecDate = lastRespecDate;
    }

    public String getLastTimeRespec() {
        return lastTimeRespec;
    }

    public void setLastTimeRespec(String lastTimeRespec) {
        this.lastTimeRespec = lastTimeRespec;
    }

    public String getRemoteStationDate() {
        return remoteStationDate;
    }

    public void setRemoteStationDate(String remoteStationDate) {
        this.remoteStationDate = remoteStationDate;
    }

    public String getJumpActivation() {
        return jumpActivation;
    }

    public void setJumpActivation(String jumpActivation) {
        this.jumpActivation = jumpActivation;
    }

    public String getJumpFatigue() {
        return jumpFatigue;
    }

    public void setJumpFatigue(String jumpFatigue) {
        this.jumpFatigue = jumpFatigue;
    }

    public String getJumpLastUpdate() {
        return jumpLastUpdate;
    }

    public void setJumpLastUpdate(String jumpLastUpdate) {
        this.jumpLastUpdate = jumpLastUpdate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCachedUntil() {
        return cachedUntil;
    }

    public void setCachedUntil(String cachedUntil) {
        this.cachedUntil = cachedUntil;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Character{");
        sb.append("characterId='").append(characterId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", homeStationId='").append(homeStationId).append('\'');
        sb.append(", DoB='").append(DoB).append('\'');
        sb.append(", race='").append(race).append('\'');
        sb.append(", bloodlineId='").append(bloodlineId).append('\'');
        sb.append(", bloodline='").append(bloodline).append('\'');
        sb.append(", ancestryID='").append(ancestryID).append('\'');
        sb.append(", ancestry='").append(ancestry).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", corporationID='").append(corporationID).append('\'');
        sb.append(", corporationName='").append(corporationName).append('\'');
        sb.append(", allianceName='").append(allianceName).append('\'');
        sb.append(", allianceId='").append(allianceId).append('\'');
        sb.append(", factionName='").append(factionName).append('\'');
        sb.append(", factionId='").append(factionId).append('\'');
        sb.append(", cloneTypeId='").append(cloneTypeId).append('\'');
        sb.append(", cloneName='").append(cloneName).append('\'');
        sb.append(", cloneSkillPoints='").append(cloneSkillPoints).append('\'');
        sb.append(", freeSkillPoints='").append(freeSkillPoints).append('\'');
        sb.append(", freeRespecs='").append(freeRespecs).append('\'');
        sb.append(", cloneJumpDate='").append(cloneJumpDate).append('\'');
        sb.append(", lastRespecDate='").append(lastRespecDate).append('\'');
        sb.append(", lastTimeRespec='").append(lastTimeRespec).append('\'');
        sb.append(", remoteStationDate='").append(remoteStationDate).append('\'');
        sb.append(", cachedUntil='").append(cachedUntil).append('\'');
        sb.append(", jumpClones=").append(jumpClones);
        sb.append(", jumpCloneImplants=").append(jumpCloneImplants);
        sb.append(", jumpActivation='").append(jumpActivation).append('\'');
        sb.append(", jumpFatigue='").append(jumpFatigue).append('\'');
        sb.append(", jumpLastUpdate='").append(jumpLastUpdate).append('\'');
        sb.append(", balance='").append(balance).append('\'');
        sb.append(", implants=").append(implants);
        sb.append(", attributes=").append(attributes);
        sb.append(", skills=").append(skills);
        sb.append(", certificates=").append(certificates);
        sb.append(", corporationRoles=").append(corporationRoles);
        sb.append(", corporationRolesAtHQ=").append(corporationRolesAtHQ);
        sb.append(", corporationRolesAtBase=").append(corporationRolesAtBase);
        sb.append(", corporationRolesAtOther=").append(corporationRolesAtOther);
        sb.append(", corporationTitles=").append(corporationTitles);
        sb.append('}');
        return sb.toString();
    }
}
