package com.example.Hello.dao;

import java.util.List;
import java.util.Map;



import org.apache.ibatis.annotations.Mapper;

import com.example.Hello.entity.BomDO;

@Mapper
public interface BomDOMapper {
	
	BomDO get(Long cateId);
	
	List<BomDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);
    
    void save(BomDO bomDO);
}
