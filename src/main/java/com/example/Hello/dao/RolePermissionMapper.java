package com.example.Hello.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.Hello.entity.RolePermission;

/**
 * 角色权限Dao层
 * @author YQ13512
 *
 */
@Mapper
public interface RolePermissionMapper {
	
	@SuppressWarnings("rawtypes")
	List<RolePermission> getAll(Map map);
	
	RolePermission getOne(Long rp_id);
	
	void save(RolePermission rolePermission);
	
	void update(RolePermission rolePermission);
	
	void delete(Long rp_id);
}
