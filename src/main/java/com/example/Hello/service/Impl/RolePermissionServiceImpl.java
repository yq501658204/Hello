package com.example.Hello.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Hello.dao.RolePermissionMapper;
import com.example.Hello.entity.RolePermission;
import com.example.Hello.service.RolePermissionService;

public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<RolePermission> getAll(Map map) {
		return rolePermissionMapper.getAll(map);
	}

	@Override
	public RolePermission getOne(Long rp_id) {
		return rolePermissionMapper.getOne(rp_id);
	}

	@Override
	public void save(RolePermission rolePermission) {
		rolePermissionMapper.save(rolePermission);
	}

	@Override
	public void update(RolePermission rolePermission) {
		rolePermissionMapper.update(rolePermission);
	}

	@Override
	public void delete(Long rp_id) {
		rolePermissionMapper.delete(rp_id);
	}

}
