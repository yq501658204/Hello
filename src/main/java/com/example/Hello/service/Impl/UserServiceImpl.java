package com.example.Hello.service.Impl;

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
	
	/**
	 * 新增
	 */
	@Override
	public void save(User user) {
		userMapper.save(user);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void delete(Long user_id) {
		userMapper.delete(user_id);
	}

	/**
	 * 修改
	 */
	@Override
	public void edit(User user) {
		userMapper.edit(user);
	}

	/**
	 * 通过id获取数据
	 */
	@Override
	public User fingById(Map<String, Object> map) {
		return userMapper.fingById(map);
	}

	/**
	 * 列表
	 */
	@Override
	public PageBean<User> datalistPage(Map<String, Object> map,Integer currentPage,Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<User> userList = userMapper.datalistPage(map);
		Integer count = userMapper.count(map);
		PageBean<User> pageBean=new PageBean<User>();
		pageBean.setItems(userList);
		pageBean.setTotalNum(count);
		return pageBean;
	}

	/**
	 * 列表(全部)
	 */
	@Override
	public List<User> listAll(Map<String, Object> map) {
		return userMapper.listAll(map);
	}

	/**
	 * 统计
	 */
	@Override
	public Integer count(Map<String, Object> map) {
		return userMapper.count(map);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void deleteAll(String[] item) {
		userMapper.deleteAll(item);
	}

}
