package com.example.Hello.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hello.dao.BomDOMapper;
import com.example.Hello.entity.BomDO;
import com.example.Hello.service.BomDOService;

@Service
public class BomDoServiceImpl implements BomDOService {

	@Autowired
	private BomDOMapper bomDOMapper;
	
	@Override
	public BomDO get(Long cateId) {
		return bomDOMapper.get(cateId);
	}

	@Override
	public List<BomDO> list(Map<String, Object> map) {
		return bomDOMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return bomDOMapper.count(map);
	}

	@Override
	public void save(BomDO bomDO) {
		bomDOMapper.save(bomDO);
	}

}
