package logic;

public class CharacterID {

    private String name;
    private String charId;

    public CharacterID() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharId() {
        return charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    @Override
    public String toString() {
        return "CharacterID{" +
                "name='" + name + '\'' +
                ", charId='" + charId + '\'' +
                '}';
    }
}
