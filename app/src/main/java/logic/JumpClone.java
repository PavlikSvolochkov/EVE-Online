package logic;

public class JumpClone {

    private String cloneName;
    private String locationId;
    private String typeId;
    private String jumpCloneId;

    public JumpClone() {
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getJumpCloneId() {
        return jumpCloneId;
    }

    public void setJumpCloneId(String jumpCloneId) {
        this.jumpCloneId = jumpCloneId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JumpClone{");
        sb.append("cloneName='").append(cloneName).append('\'');
        sb.append(", locationId='").append(locationId).append('\'');
        sb.append(", typeId='").append(typeId).append('\'');
        sb.append(", jumpCloneId='").append(jumpCloneId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
