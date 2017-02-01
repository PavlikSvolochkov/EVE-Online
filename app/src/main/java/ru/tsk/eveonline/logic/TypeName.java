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
        return "TypeName{" +
                "typeID='" + typeID + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
