package com.example.Hello.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.Hello.entity.User;

/**
 * 用户Dao层
 * @author YQ13512
 *
 */
@Mapper
public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Map<String,Object> map);
	
	void save(User user);
	
	void update(User user);
	
	void delete(Long user_id);
	
}
