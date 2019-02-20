package com.example.Hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.Hello.entity.Permission;

/**
 * 权限Dao层
 * @author YQ13512
 *
 */
@Mapper
public interface PermissionMapper {

	List<Permission> getAll();
	
	Permission getOne(Long permission_id);
	
	void save(Permission permission);
	
	void update(Permission permission);
	
	void delete(Long permission_id);
	
	String getPermission(Long permission_id);
}
