package com.xhyxt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhyxt.bean.TeachResource;
import com.xhyxt.mapper.TeachResourceMapper;
import com.xhyxt.service.TeachResourceService;

@Service
public class TeachResourceServiceImpl implements TeachResourceService {
	
	@Autowired
	private TeachResourceMapper teachResourceMapper;
	
	public TeachResourceServiceImpl() {
		super();
	}

	@Override
	public List<TeachResource> selAll(String type) {
		List<TeachResource> teachResource = teachResourceMapper.selAll(type);
		return teachResource;
	}

	@Override
	public void insert(String type, String name, String select, String path) {
		teachResourceMapper.insert(type, name, select, path);
		
	}

	@Override
	public void delete(String type, String name, String path) {
		teachResourceMapper.delete(type, name, path);
		
	}

}
