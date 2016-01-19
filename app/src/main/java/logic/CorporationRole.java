package logic;

public class CorporationRole {

  private String roleName;
  private String roleId;

  public CorporationRole() {
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "CorporationRole{" +
            "roleName='" + roleName + '\'' +
            ", roleId='" + roleId + '\'' +
            '}';
  }
}
