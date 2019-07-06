package com.xhyxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.xhyxt.bean.Picture;

@Component
public interface PictureMapper {
	public List<Picture> selAll();
	public Picture selectPicture(@Param("index")String index);
	public void updatePicture(@Param("name")String name,@Param("index")String index);
}
