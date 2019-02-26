package com.example.Hello.entity;

/**
 * 学生实体类
 * @author YQ13512
 *
 */
public class Student {

	private Long student_id;
	private String name;
	private Integer age;

	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public String getname() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getage() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


}