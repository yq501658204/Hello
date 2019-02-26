package com.example.Hello.service;

import java.util.List;
import java.util.Map;

import com.example.Hello.entity.UserRole;

public interface UserRoleService {

	@SuppressWarnings("rawtypes")
	List<UserRole> getAll(Map map);
	
	UserRole getOne(Long ur_id);
	
	void save(UserRole userRole);
	
	void update(UserRole userRole);
	
	void delete(Long ur_id);
	
}
