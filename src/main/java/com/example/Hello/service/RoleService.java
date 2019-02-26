package com.example.Hello.service;

import java.util.List;

import com.example.Hello.entity.Role;

public interface RoleService {

	List<Role> getAll();
	
	Role getOne(Long role_id);
	
	void save(Role role);
	
	void update(Role role);
	
	void delete(Long role_id);
	
	String getRole(Long role_id);
	
}
