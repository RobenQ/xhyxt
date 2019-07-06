package com.xhyxt.service;

import java.util.List;

import com.xhyxt.bean.TeachResource;

public interface TeachResourceService {
	public List<TeachResource> selAll(String type);
	public void insert(String type,String name,String select,String path);
	public void delete(String type,String name,String path);
}
