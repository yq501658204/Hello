package com.example.Hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.Hello.entity.Role;

/**
 * 角色Dao层
 * @author YQ13512
 *
 */
@Mapper
public interface RoleMapper {

	List<Role> getAll();
	
	Role getOne(Long role_id);
	
	void save(Role role);
	
	void update(Role role);
	
	void delete(Long role_id);
	
	String getRole(Long role_id);
}
