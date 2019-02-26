package com.example.Hello.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Hello.dao.RoleMapper;
import com.example.Hello.entity.Role;
import com.example.Hello.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> getAll() {
		return roleMapper.getAll();
	}

	@Override
	public Role getOne(Long role_id) {
		return roleMapper.getOne(role_id);
	}

	@Override
	public void save(Role role) {
		roleMapper.save(role);
	}

	@Override
	public void update(Role role) {
		roleMapper.update(role);
	}

	@Override
	public void delete(Long role_id) {
		roleMapper.delete(role_id);
	}

	@Override
	public String getRole(Long role_id) {
		return roleMapper.getRole(role_id);
	}

}
