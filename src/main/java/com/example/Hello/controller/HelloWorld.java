package com.example.Hello.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Hello.dao.BomDOMapper;
import com.example.Hello.entity.BomDO;
import com.example.Hello.util.SessionUtil;

@Controller
public class HelloWorld {
	
	@Autowired
    private BomDOMapper bomDOMapper;
	
	@RequestMapping("/hehe")
	public String HelloW(){
		return "hehe";
	}
	
    //简化，直接通过这里设置session
    @GetMapping("/set/{sess}")
    @ResponseBody
    public Object setSession(@PathVariable("sess") String sess){
        HttpSession httpSession= SessionUtil.getSession();
        httpSession.setAttribute("corp",sess);
        return "ok";
    }
    
    @GetMapping("/add")
    @ResponseBody
    public String add(){
    	BomDO bomDO = new BomDO();
    	bomDO.setCateCode("dsd");
    	bomDO.setParentId(123L);
    	bomDO.setName("zhangsan");
    	bomDO.setUnit("lisi");
    	bomDO.setUsedCount(456D);
    	bomDO.setSpecify("wangwu");
    	bomDO.setProperty(12);
    	bomDO.setStatus(23);
    	bomDO.setDescription("desr");
    	bomDOMapper.save(bomDO);
    	return "OJBK";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<BomDO> list(){
        Map<String, Object> query = new HashMap<>(16);
        List<BomDO> bomList = bomDOMapper.list(query);
        for (BomDO bomDO : bomList) {
			System.out.println(bomDO);
		}
        return bomList;
    }
    
    @GetMapping("/count")
    @ResponseBody
    public Object getCount(){
        //要测试的方法
        Map<String, Object> map = new HashMap<String, Object>();
        return bomDOMapper.count(map);
    }   
}
