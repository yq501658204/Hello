package com.example.Hello.entity;

/**
 * 角色权限中间表
 * @author YQ13512
 *
 */
public class RolePermission {

	private Long rp_id;
	private Long role_id;
	private Long permission_id;
	
	public Long getRp_id() {
		return rp_id;
	}
	public void setRp_id(Long rp_id) {
		this.rp_id = rp_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Long getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Long permission_id) {
		this.permission_id = permission_id;
	}
	
	
}
