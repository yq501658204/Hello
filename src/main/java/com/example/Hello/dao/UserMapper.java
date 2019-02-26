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
	
	void save(User user);
	
	void delete(Long user_id);
	
	void edit(User user);
	
	User fingById(Map<String, Object> map);
	
	List<User> datalistPage(Map<String, Object> map);
	
	List<User> listAll(Map<String, Object> map);
	
	Integer count(Map<String, Object> map);
	
	void deleteAll(String[] item);
}
