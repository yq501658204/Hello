package com.example.Hello.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class AppController {
	
	@RequestMapping("/getTime")
	public void getTime(String timenow){
		System.out.println("看看得到的时间是什么样子的："+timenow);
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public JSONObject getUser(){
		JSONObject result = new JSONObject();
		result.put("id", 132);
		result.put("username", 132);
		result.put("sex", 1);
		result.put("city", 132);
		result.put("sign", 132);
		result.put("experience", 132);
		result.put("score", 132);
		result.put("classify", 132);
		result.put("wealth", 132);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("count", 1);
		jsonObject.put("msg", "");
		List<JSONObject> list=new ArrayList<JSONObject>();
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		list.add(result);
		jsonObject.put("data", list);
		return jsonObject;
	}
	
}
