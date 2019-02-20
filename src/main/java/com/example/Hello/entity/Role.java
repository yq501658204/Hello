package com.example.Hello.entity;

/**
 * 用户角色中间表
 * @author YQ13512
 *
 */
public class Role {
	
	private Long role_id;
	//后台判断所使用的角色名称
	private String server_name;
	//前端展示用角色名称
	private String client_name;
	
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
}
