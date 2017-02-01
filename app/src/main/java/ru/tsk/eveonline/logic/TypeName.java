package ru.tsk.eveonline.logic;

public class TypeName {

    // <row typeID="645" typeName="Dominix" />

    private String typeID;
    private String typeName;

    public TypeName() {

    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TypeName{");
        sb.append("typeID='").append(typeID).append('\'');
        sb.append(", typeName='").append(typeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
