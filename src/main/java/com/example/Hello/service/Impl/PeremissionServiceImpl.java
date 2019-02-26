package com.example.Hello.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Hello.dao.PermissionMapper;
import com.example.Hello.entity.Permission;
import com.example.Hello.service.PermissionService;

public class PeremissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> getAll() {
		return permissionMapper.getAll();
	}

	@Override
	public Permission getOne(Long permission_id) {
		return permissionMapper.getOne(permission_id);
	}

	@Override
	public void save(Permission permission) {
		permissionMapper.save(permission);
	}

	@Override
	public void update(Permission permission) {
		permissionMapper.update(permission);
	}

	@Override
	public void delete(Long permission_id) {
		permissionMapper.delete(permission_id);
	}

	@Override
	public String getPermission(Long permission_id) {
		return permissionMapper.getPermission(permission_id);
	}

}
