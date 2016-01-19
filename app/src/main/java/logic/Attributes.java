package logic;

public class Attributes {

  private String intelligence;
  private String memory;
  private String charisma;
  private String perception;
  private String willpower;

  public Attributes() {
  }

  public String getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(String intelligence) {
    this.intelligence = intelligence;
  }

  public String getMemory() {
    return memory;
  }

  public void setMemory(String memory) {
    this.memory = memory;
  }

  public String getCharisma() {
    return charisma;
  }

  public void setCharisma(String charisma) {
    this.charisma = charisma;
  }

  public String getPerception() {
    return perception;
  }

  public void setPerception(String perception) {
    this.perception = perception;
  }

  public String getWillpower() {
    return willpower;
  }

  public void setWillpower(String willpower) {
    this.willpower = willpower;
  }

  @Override
  public String toString() {
    return "Attributes{" +
            "intelligence='" + intelligence + '\'' +
            ", memory='" + memory + '\'' +
            ", charisma='" + charisma + '\'' +
            ", perception='" + perception + '\'' +
            ", willpower='" + willpower + '\'' +
            '}';
  }
}
