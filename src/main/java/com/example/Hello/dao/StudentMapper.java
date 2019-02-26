package com.example.Hello.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.Hello.entity.Student;

/**
 * hello_studentDao层
 * @author YQ13512
 *
 */
@Mapper
public interface StudentMapper {

	void save(Student student);

	void delete(Long student_id);

	void edit(Student student);

	Student fingById(Map<String, Object> map);

	List<Student> datalistPage(Map<String, Object> map);

	List<Student> listAll(Map<String, Object> map);

	Integer count(Map<String, Object> map);

	void deleteAll(String[] item);
}