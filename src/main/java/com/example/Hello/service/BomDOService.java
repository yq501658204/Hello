package com.example.Hello.service;

import java.util.List;
import java.util.Map;

import com.example.Hello.entity.BomDO;

public interface BomDOService {

	BomDO get(Long cateId);
	
	List<BomDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);
    
    void save(BomDO bomDO);
	
}
