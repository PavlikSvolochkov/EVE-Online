package ru.tsk.eveonline.logic;

public class Implant {

    private String typeId;
    private String typeName;

    public Implant() {
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Implant{");
        sb.append("typeId='").append(typeId).append('\'');
        sb.append(", typeName='").append(typeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
