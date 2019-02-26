package com.example.Hello.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hello.dao.StudentMapper;
import com.example.Hello.entity.Student;
import com.example.Hello.service.StudentService;
import com.example.Hello.util.PageBean;
import com.github.pagehelper.PageHelper;

/**
 * hello_studentService实现类
 * @author YQ13512
 *
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;

	/**
	 * 新增
	 */
	@Override
	public void save(Student student) {
		studentMapper.save(student);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Long student_id) {
		studentMapper.delete(student_id);
	}

	/**
	 * 修改
	 */
	@Override
	public void edit(Student student) {
		studentMapper.edit(student);
	}

	/**
	 * 通过id获取数据
	 */
	@Override
	public Student fingById(Map<String, Object> map) {
		return studentMapper.fingById(map);
	}

	/**
	 * 列表
	 */
	@Override
	public PageBean<Student> datalistPage(Map<String, Object> map,Integer currentPage,Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<Student> studentList = studentMapper.datalistPage(map);
		Integer count = studentMapper.count(map);
		PageBean<Student> pageBean=new PageBean<Student>();
		pageBean.setItems(studentList);
		pageBean.setTotalNum(count);
		return pageBean;
	}

	/**
	 * 列表(全部)
	 */
	@Override
	public List<Student> listAll(Map<String, Object> map) {
		return studentMapper.listAll(map);
	}

	/**
	 * 统计
	 */
	@Override
	public Integer count(Map<String, Object> map) {
		return studentMapper.count(map);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void deleteAll(String[] item) {
		studentMapper.deleteAll(item);
	}

}