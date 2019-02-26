package com.example.Hello.controller.student;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Hello.controller.base.BaseController;
import com.example.Hello.entity.Student;
import com.example.Hello.service.StudentService;
import com.example.Hello.util.PageBean;

/**
 * hello_student控制层
 * @author YQ13512
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController{

	@Autowired
	private StudentService studentService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public ModelAndView list(Integer currentPage,Integer pageSize){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("student/list");
		if(permitted){
			Map<String, Object> map = this.getMap();
			PageBean<Student> pageBean = studentService.datalistPage(map, currentPage, pageSize);
			mv.addObject("studentList", pageBean.getItems());
			mv.setViewName("student/list");
			return mv;
		}else{
			mv.setViewName("404");
			return mv;
		}
	}

	/**
	 * 增加
	 */
	@RequestMapping("/save")
	public ModelAndView save(Student student){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("student/add");
		if(permitted){
			studentService.save(student);
			mv.setViewName("redirect:student/list");
			return mv;
		}else{
			mv.setViewName("404");
			return mv;
		}
	}

	/**
	 * 修改
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(Student student){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("student/update");
		if(permitted){
			studentService.edit(student);
			mv.setViewName("redirect:student/list");
			return mv;
		}else{
			mv.setViewName("404");
			return mv;
		}
	}

	/**
	 * 去新增页面
	 */
	@RequestMapping("/goAdd")
	public ModelAndView goAdd(){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("student/student_edit");
		return mv;
	}

	/**
	 * 去修改页面
	 */
	@RequestMapping("/goEdit")
	public ModelAndView goEdit(Long student_id){
		ModelAndView mv = this.getModelAndView();
		Map<String, Object> map = this.getMap();
		map.put("student_id", student_id);
		Student student = studentService.fingById(map);
		mv.addObject("student", student);
		mv.setViewName("student/student_edit");
		return mv;
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public ModelAndView delete(Long student_id){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("student/delete");
		if(permitted){
			studentService.delete(student_id);
			mv.setViewName("redirect:student/list");
			return mv;
		}else{
			mv.setViewName("404");
			return mv;
		}
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("deleteAll")
	public ModelAndView deletaAll(String[] item){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("student/deleteAll");
		if(permitted){
			studentService.deleteAll(item);
			mv.setViewName("redirect:student/list");
			return mv;
		}else{
			mv.setViewName("404");
			return mv;
		}
	}

}