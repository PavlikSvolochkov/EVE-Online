package ru.tsk.eveonline.logic;

public class Skill {

    private String typeId;
    private String published;
    private String level;
    private String skillPoints;

    public Skill() {
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(String skillPoints) {
        this.skillPoints = skillPoints;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "typeId='" + typeId + '\'' +
                ", published='" + published + '\'' +
                ", level='" + level + '\'' +
                ", skillPoints='" + skillPoints + '\'' +
                '}';
    }
}
