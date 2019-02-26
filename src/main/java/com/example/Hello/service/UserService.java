package com.example.Hello.service;

import java.util.List;
import java.util.Map;

import com.example.Hello.entity.User;
import com.example.Hello.util.PageBean;

/**
 * 用户Service接口
 * @author YQ13512
 *
 */
public interface UserService {
	
	void save(User user);
	
	void delete(Long user_id);
	
	void edit(User user);
	
	User fingById(Map<String, Object> map);
	
	PageBean<User> datalistPage(Map<String, Object> map,Integer currentPage,Integer pageSize);
	
	List<User> listAll(Map<String, Object> map);
	
	Integer count(Map<String, Object> map);
	
	void deleteAll(String[] item);
	
}
