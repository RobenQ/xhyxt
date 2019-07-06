package com.xhyxt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhyxt.bean.Admin;
import com.xhyxt.mapper.AdminMapper;
import com.xhyxt.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public AdminServiceImpl() {
		super();
	}

	//管理员登录
	public Admin login(int id, String password) {
		Admin admin =  adminMapper.login(id, password);
		return admin;
	}

}
