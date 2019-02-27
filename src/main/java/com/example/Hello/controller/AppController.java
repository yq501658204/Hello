package com.example.Hello.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.Hello.util.FileUtil;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/app")
public class AppController {
	
	@RequestMapping("/getTime")
	public void getTime(String timenow){
		System.out.println("看看得到的时间是什么样子的："+timenow);
	}

	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file) throws Exception {
		byte[] bytes = file.getBytes();
		String originalFilename = file.getOriginalFilename();
		FileUtil.uploadFile(bytes,"F:\\YQ\\Project\\Hello\\src\\main\\resources\\static\\img\\",originalFilename);
		return "OJBK";
	}


}
