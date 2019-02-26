package com.example.Hello.service;

import java.util.List;
import java.util.Map;

import com.example.Hello.entity.Student;
import com.example.Hello.util.PageBean;

/**
 * hello_studentService接口
 * @author YQ13512
 *
 */
public interface StudentService {

	void save(Student student);

	void delete(Long student_id);

	void edit(Student student);

	Student fingById(Map<String, Object> map);

	PageBean<Student> datalistPage(Map<String, Object> map,Integer currentPage,Integer pageSize);

	List<Student> listAll(Map<String, Object> map);

	Integer count(Map<String, Object> map);

	void deleteAll(String[] item);

}