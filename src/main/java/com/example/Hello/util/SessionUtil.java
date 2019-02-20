package com.example.Hello.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * session工具类
 * @author YQ13512
 *
 */
public class SessionUtil {
	
	public static HttpSession getSession(){
		HttpSession session= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		return session;
	}
	
}
