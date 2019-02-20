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
	
	List<User> getAll();

	PageBean<User> getByPage(Integer currentPage,Integer pageSize);
	
	User getOne(Map<String,Object> map);
	
	void save(User user);
	
	void update(User user);
	
	void delete(Long user_id);
	
}
