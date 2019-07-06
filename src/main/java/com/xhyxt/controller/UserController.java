package com.xhyxt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xhyxt.bean.Picture;
import com.xhyxt.bean.TeachResource;
import com.xhyxt.service.PictureService;
import com.xhyxt.service.TeachResourceService;
import com.xhyxt.utils.AdminUtil;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private TeachResourceService teachResourceService;
	@Autowired
	private PictureService pictureService;
	
//	@RequestMapping(value="index")
//	public ModelAndView index() {
//		ModelAndView mv = new ModelAndView();
//		Picture img1 = pictureService.selectPicture("图1");
//		Picture img2 = pictureService.selectPicture("图2");
//		Picture img3 = pictureService.selectPicture("图3");
//		Picture img4 = pictureService.selectPicture("图4");
//		Picture img5 = pictureService.selectPicture("图5");
//		mv.addObject("img1", img1.getName());
//		mv.addObject("img2", img2.getName());
//		mv.addObject("img3", img3.getName());
//		mv.addObject("img4", img4.getName());
//		mv.addObject("img5", img5.getName());
//		mv.setViewName("/jsp/ind");
//		return mv;
//	}
	
	@RequestMapping(value="/downfile")
	public void downFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String path = request.getParameter("path");
		String name = request.getParameter("name");
		System.out.println("路径："+path+"   文件名称："+name);
//		String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//		System.out.println(path2);
		AdminUtil.download(request, response,path,name,name);
	}
	
	@RequestMapping(value="to2_1_1")
	public String to2_1_1() {
		return "/jsp/2_1_1";
	}
	
	@RequestMapping(value="to2_2_1")
	public String to2_2_1() {
		return "/jsp/2_2_1";
	}
	
	@RequestMapping(value="to2_3_1")
	public String to2_3_1() {
		return "/jsp/2_3_1";
	}
	
	@RequestMapping(value="to3_1_1")
	public String to3_1_1() {
		return "/jsp/3_1_1";
	}
	
	@RequestMapping(value="to3_2_1")
	public String to3_2_1() {
		return "/jsp/3_2_1";
	}
	
	@RequestMapping(value="to4_1_1")
	public String to4_1_1() {
		return "/jsp/4_1_1";
	}
	
	@RequestMapping(value="to4_1_1s")
	public ModelAndView to4_1_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("课件");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/4_1_1s");
		return mv;
	}
	
	@RequestMapping(value="to4_2_1")
	public String to4_2_1() {
		return "/jsp/4_2_1";
	}
	
	@RequestMapping(value="to4_2_1s")
	public ModelAndView to4_2_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("电子教案");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/4_2_1s");
		return mv;
	}
	
	@RequestMapping(value="to4_3_1")
	public String to4_3_1() {
		return "/jsp/4_3_1";
	}
	
	@RequestMapping(value="to4_3_1s")
	public ModelAndView to4_3_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("视频");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/4_3_1s");
		return mv;
	}
	
	@RequestMapping(value="/showvideo")
	public ModelAndView showvideo(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String path = request.getParameter("path");
		String name = request.getParameter("name");
		System.out.println("路径："+path+"   文件名称："+name);
		ModelAndView mv = new ModelAndView();
//		String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//		System.out.println(path2);
//		String filePath = request.getSession().getServletContext().getRealPath(path)+"\\"+name;
//		System.out.println(filePath);
		mv.addObject("name", name);
		mv.addObject("filePath", path);
		mv.setViewName("/jsp/showVideo");
		return mv;
	}
	
	@RequestMapping(value="to4_4_1")
	public String to4_4_1() {
		return "/jsp/4_4_1";
	}
	
	@RequestMapping(value="to5_1_1")
	public String to5_1_1() {
		return "/jsp/5_1_1";
	}
	
	@RequestMapping(value="to5_1_1s")
	public ModelAndView to5_1_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("实验指导书");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/5_1_1s");
		return mv;
	}
	
	@RequestMapping(value="to5_2_1")
	public String to5_2_1() {
		return "/jsp/5_2_1";
	}
	
	@RequestMapping(value="to5_2_1s")
	public ModelAndView to5_2_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("虚拟仿真");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/5_2_1s");
		return mv;
	}
	
	@RequestMapping(value="to5_3_1")
	public String to5_3_1() {
		return "/jsp/5_3_1";
	}
	
	@RequestMapping(value="to5_3_1s")
	public ModelAndView to5_3_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("matlab仿真");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/5_3_1s");
		return mv;
	}
	
	@RequestMapping(value="to6_1_1")
	public String to6_1_1() {
		return "/jsp/6_1_1";
	}
	
	@RequestMapping(value="to6_1_1s")
	public ModelAndView to6_1_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("习题");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/6_1_1s");
		return mv;
	}
	
	@RequestMapping(value="to6_2_1")
	public String to6_2_1() {
		return "/jsp/6_2_1";
	}
	
	@RequestMapping(value="to6_2_1s")
	public ModelAndView to6_2_1s() {
		ModelAndView mv = new ModelAndView();
		List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("试题");
		mv.addObject("resource", resource);
		mv.setViewName("/jsp/6_2_1s");
		return mv;
	}
}
