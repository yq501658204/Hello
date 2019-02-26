package com.example.Hello.controller.user;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Hello.controller.base.BaseController;
import com.example.Hello.entity.User;
import com.example.Hello.service.UserService;
import com.example.Hello.util.PageBean;

/**
 * 用户控制层
 * @author YQ13512
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public ModelAndView list(Integer currentPage,Integer pageSize){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("user/list");
		if(permitted){
			Map<String, Object> map = this.getMap();
			PageBean<User> pageBean = userService.datalistPage(map, currentPage, pageSize);
			mv.addObject("userList", pageBean.getItems());
			mv.setViewName("user/list");
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
	public ModelAndView save(User user){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("user/add");
		if(permitted){
			userService.save(user);
			mv.setViewName("redirect:user/list");
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
	public ModelAndView edit(User user){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("user/update");
		if(permitted){
			userService.edit(user);
			mv.setViewName("redirect:user/list");
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
		mv.setViewName("user/user_edit");
		return mv;
	}
	
	/**
	 * 去修改页面
	 */
	@RequestMapping("/goEdit")
	public ModelAndView goEdit(Long user_id){
		ModelAndView mv = this.getModelAndView();
		Map<String, Object> map = this.getMap();
		map.put("user_id", user_id);
		User user = userService.fingById(map);
		mv.addObject("user", user);
		mv.setViewName("user/user_edit");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public ModelAndView delete(Long user_id){
		ModelAndView mv = this.getModelAndView();
		Subject subject = SecurityUtils.getSubject();//进行权限校验
		boolean permitted = subject.isPermitted("user/delete");
		if(permitted){
			userService.delete(user_id);
			mv.setViewName("redirect:user/list");
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
		boolean permitted = subject.isPermitted("user/deleteAll");
		if(permitted){
			userService.deleteAll(item);
			mv.setViewName("redirect:user/list");
			return mv;
		}else{
			mv.setViewName("404");
			return mv;
		}
	}
	
}
