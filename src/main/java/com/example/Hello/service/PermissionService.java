package com.example.Hello.service;

import java.util.List;

import com.example.Hello.entity.Permission;

public interface PermissionService {

	List<Permission> getAll();
	
	Permission getOne(Long permission_id);
	
	void save(Permission permission);
	
	void update(Permission permission);
	
	void delete(Long permission_id);
	
	String getPermission(Long permission_id);
	
}
