package logic;

public class CorporationRoleAtHQ {

  private String roleName;
  private String roleId;

  public CorporationRoleAtHQ() {
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
    return "CorporationRoleAtHQ{" +
            "roleName='" + roleName + '\'' +
            ", roleId='" + roleId + '\'' +
            '}';
  }
}
