package com.hsbc.bts.models;

public class Role {
	private int roleId;
	private int roleName;
	
	public Role() {
		super();
	}

	public Role(int roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(int roleId, int roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleName() {
		return roleName;
	}

	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
