package com.xhyxt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhyxt.bean.Picture;
import com.xhyxt.mapper.PictureMapper;
import com.xhyxt.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService{
	
	@Autowired
	private PictureMapper pictureMapper;
	
	
	@Override
	public List<Picture> selAll() {
		return pictureMapper.selAll();
	}


	@Override
	public Picture selectPicture(String index) {
		return pictureMapper.selectPicture(index);
	}


	@Override
	public void updatePicture(String name, String index) {
		pictureMapper.updatePicture(name, index);
	}

}
