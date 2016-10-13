package logic;

public class CorporationRoleAtOther {

    private String roleName;
    private String roleId;

    public CorporationRoleAtOther() {
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
        final StringBuilder sb = new StringBuilder("CorporationRoleAtOther{");
        sb.append("roleName='").append(roleName).append('\'');
        sb.append(", roleId='").append(roleId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
