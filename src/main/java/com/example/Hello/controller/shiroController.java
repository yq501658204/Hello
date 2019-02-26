package com.example.Hello.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Hello.dao.UserMapper;
import com.example.Hello.entity.User;
import com.example.Hello.service.UserService;
import com.example.Hello.util.PageBean;

import net.sf.json.JSONObject;

/**
 * shiro测试
 * @author YQ13512
 *
 */
@Controller
public class shiroController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	
	@RequestMapping("/app/test")
	@ResponseBody
	public JSONObject test(){
		/*List<User> userList = userService.getByPage(1, 2);
		for (User user : userList) {
			System.out.println(user.getUsername());
		}*/
		Map<String, Object> map=new HashMap<String, Object>();
		PageBean<User> pageBean = userService.datalistPage(map, 1, 2);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pageBean", pageBean);
		return jsonObject;
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "helloworld";
	}
	
	@RequestMapping("/logout")
	public String loginOut(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Map<String, Object> map){
		System.out.println("登陆失败");
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception :"+exception);
		String msg="";
		if(exception!=null){
			if (UnknownAccountException.class.getName().equals(exception)) {
	            System.out.println("UnknownAccountException -- > 账号不存在：");
	            msg = "UnknownAccountException -- > 账号不存在：";
	        } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
	            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
	            msg = "IncorrectCredentialsException -- > 密码不正确：";
	        } else if ("kaptchaValidateFailed".equals(exception)) {
	            System.out.println("kaptchaValidateFailed -- > 验证码错误");
	            msg = "kaptchaValidateFailed -- > 验证码错误";
	        } else {
	            msg = "else >> "+exception;
	            System.out.println("else -- >" + exception);
	        }
		}
		map.put("msg", msg);
		return "login";
	}
	
	//@RequiresPermissions("userInfo")
	@RequestMapping("/userInfo")
	public String userinfo(){
		Subject subject = SecurityUtils.getSubject();
		boolean permitted = subject.isPermitted("dsads");
		System.out.println(permitted);
		return "userInfo";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String set(){
		User user = new User();
		user.setUser_id(1L);
		user.setUsername("zhangsan");
		userMapper.edit(user);
		return "可以哦";
	}
	
	
	
	
	
}
