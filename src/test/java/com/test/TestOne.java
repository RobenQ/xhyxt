package com.test;

import java.security.NoSuchAlgorithmException;

import com.xhyxt.utils.AdminUtil;

public class TestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(new AdminUtil().sHAEncrypt("12345"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
