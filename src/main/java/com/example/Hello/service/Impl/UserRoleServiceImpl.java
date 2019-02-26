package com.example.Hello.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Hello.dao.UserRoleMapper;
import com.example.Hello.entity.UserRole;
import com.example.Hello.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<UserRole> getAll(Map map) {
		return userRoleMapper.getAll(map);
	}

	@Override
	public UserRole getOne(Long ur_id) {
		return userRoleMapper.getOne(ur_id);
	}

	@Override
	public void save(UserRole userRole) {
		userRoleMapper.save(userRole);
	}

	@Override
	public void update(UserRole userRole) {
		userRoleMapper.update(userRole);
	}

	@Override
	public void delete(Long ur_id) {
		userRoleMapper.delete(ur_id);
	}

}
