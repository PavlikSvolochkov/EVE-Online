package ru.tsk.eveonline.logic;

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
        return "CorporationRoleAtOther{" +
                "roleName='" + roleName + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
