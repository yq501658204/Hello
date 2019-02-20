package com.example.Hello.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.Hello.entity.UserRole;

/**
 * 用户角色Dao层
 * @author YQ13512
 *
 */
@Mapper
public interface UserRoleMapper {

	@SuppressWarnings("rawtypes")
	List<UserRole> getAll(Map map);
	
	UserRole getOne(Long ur_id);
	
	void save(UserRole userRole);
	
	void update(UserRole userRole);
	
	void delete(Long ur_id);
	
}
