package com.example.Hello.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hello.dao.UserMapper;
import com.example.Hello.entity.User;
import com.example.Hello.service.UserService;
import com.example.Hello.util.PageBean;
import com.github.pagehelper.PageHelper;

/**
 * 用户Service实现类
 * @author YQ13512
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAll() {
		List<User> userList = userMapper.getAll();
		return userList;
	}
	
	@Override
	public PageBean<User> getByPage(Integer currentPage,Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<User> userList = userMapper.getAll();
		for (User user : userList) {
			System.out.println(user);
		}
		System.out.println("我就看看我的user"+userList);
		PageBean<User> pageBean = new PageBean<User>(userList);
		Map<String, Object> map=new HashMap<String, Object>();
		Integer count = userMapper.count(map);
		PageBean<User> pageBean2 = new PageBean<User>(currentPage, pageSize, count);
		pageBean2.setItems(userList);
		System.out.println("111111111:"+pageBean);
		System.out.println("222222222:"+pageBean2);
		System.out.println(pageBean2.getItems());
		return pageBean2;
	}

	@Override
	public User getOne(Map<String, Object> map) {
		User user = userMapper.getOne(map);
		return user;
	}

	@Override
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public void delete(Long user_id) {
		userMapper.delete(user_id);
	}


}
