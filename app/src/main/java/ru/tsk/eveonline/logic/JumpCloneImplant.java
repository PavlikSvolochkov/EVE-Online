package ru.tsk.eveonline.logic;

public class JumpCloneImplant {

    private String typeID;
    private String jumpCloneID;
    private String typeName;

    public JumpCloneImplant() {
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getJumpCloneID() {
        return jumpCloneID;
    }

    public void setJumpCloneID(String jumpCloneID) {
        this.jumpCloneID = jumpCloneID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "JumpCloneImplant{" +
                "typeID='" + typeID + '\'' +
                ", jumpCloneID='" + jumpCloneID + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
