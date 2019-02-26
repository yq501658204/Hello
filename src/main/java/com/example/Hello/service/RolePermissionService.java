package com.example.Hello.service;

import java.util.List;
import java.util.Map;

import com.example.Hello.entity.RolePermission;

public interface RolePermissionService {

	@SuppressWarnings("rawtypes")
	List<RolePermission> getAll(Map map);
	
	RolePermission getOne(Long rp_id);
	
	void save(RolePermission rolePermission);
	
	void update(RolePermission rolePermission);
	
	void delete(Long rp_id);
	
}
