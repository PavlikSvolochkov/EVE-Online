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
    return "JumpClone{" +
            "cloneName='" + cloneName + '\'' +
            ", locationId='" + locationId + '\'' +
            ", typeId='" + typeId + '\'' +
            ", jumpCloneId='" + jumpCloneId + '\'' +
            '}';
  }
}
