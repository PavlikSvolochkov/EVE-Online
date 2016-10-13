package logic;

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
        final StringBuilder sb = new StringBuilder("JumpCloneImplant{");
        sb.append("typeID='").append(typeID).append('\'');
        sb.append(", jumpCloneID='").append(jumpCloneID).append('\'');
        sb.append(", typeName='").append(typeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
