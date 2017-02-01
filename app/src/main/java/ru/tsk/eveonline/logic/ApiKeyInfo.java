package ru.tsk.eveonline.logic;

import java.util.ArrayList;
import java.util.List;

public class ApiKeyInfo {
    /**
     * <result>
     * <key accessMask="134217727" type="Character" expires="">
     * <rowset name="characters" key="characterID" columns="characterID,characterName,corporationID,corporationName,allianceID,allianceName,factionID,factionName">
     * <row characterID="1655827332" characterName="Hel O'Ween" corporationID="1226284052" corporationName="Men On A Mission" allianceID="0" allianceName="" factionID="0" factionName="" />
     * </rowset>
     * </key>
     * </result>
     */

    private APIKey apiKey;
    private List<CharacterLite> charList;

    public ApiKeyInfo() {
        this.apiKey = new APIKey();
        this.charList = new ArrayList<>();
    }

    public APIKey getApiKey() {
        return apiKey;
    }

    public void setApiKey(APIKey apiKey) {
        this.apiKey = apiKey;
    }

    public List<CharacterLite> getCharList() {
        return charList;
    }

    public void setCharList(List<CharacterLite> charList) {
        this.charList = charList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiKeyInfo{");
        sb.append("apiKey=").append(apiKey);
        sb.append(", charList=").append(charList);
        sb.append('}');
        return sb.toString();
    }
}
