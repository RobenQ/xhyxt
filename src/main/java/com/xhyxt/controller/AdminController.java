package com.xhyxt.controller;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xhyxt.bean.Admin;
import com.xhyxt.bean.Picture;
import com.xhyxt.bean.TeachResource;
import com.xhyxt.service.AdminService;
import com.xhyxt.service.PictureService;
import com.xhyxt.service.TeachResourceService;
import com.xhyxt.serviceimpl.AdminServiceImpl;
import com.xhyxt.utils.AdminUtil;

@Controller()
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private TeachResourceService teachResourceService;
	@Autowired
	private PictureService pictureService;
	
//	@RequestMapping("ajax")
//	public void ajax(HttpServletRequest request,HttpServletResponse response ) throws NoSuchAlgorithmException, IOException {
//		int id = Integer.parseInt(request.getParameter("ID"));
//		String password = AdminUtil.sHAEncrypt(request.getParameter("password"));
//		Admin admin = adminService.login(id, password);
//		if(admin==null) {
//			request.setAttribute("result", "ERROR");
//			System.out.println(request.getParameter("ID")+"登录失败1");
//		}
//	}
	
	@RequestMapping(value="go")
	public String adminGo() {
		return"/jsp/login";
	}
	//管理员登录控制
	@RequestMapping(value="login" ,method= {RequestMethod.POST})
	public ModelAndView adminLogin(HttpServletRequest request) throws NoSuchAlgorithmException {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("ID"));
		String password = AdminUtil.sHAEncrypt(request.getParameter("password"));
		Admin admin = adminService.login(id, password);
		if(admin==null) {
			mv.setViewName("/jsp/login");
			System.out.println(request.getParameter("ID")+"登录失败");
		}else {
//			System.out.println(admin.getPassword());
//			System.out.println(password);
//			mv.addObject(admin);
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			mv.setViewName("/jsp/adminIndex");
			System.out.println("["+admin.getId()+admin.getName()+"]登录成功");
		}
		return mv;
	}
	
	@RequestMapping(value="update21")
	public String update21(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			AdminUtil.updateFile2(request,"/files/two","2_1.pdf");
			return "jsp/2_1";
		}
		return null;
	}
	
	@RequestMapping(value="update22")
	public String update22(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			AdminUtil.updateFile2(request,"/files/two","2_2.pdf");
			return "jsp/2_2";
		}
		return null;
	}
	
	@RequestMapping(value="update23")
	public String update23(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			AdminUtil.updateFile2(request, "/files/two","2_3.pdf");
			return "jsp/2_3";
		}
		return null;
	}
	
	@RequestMapping(value="update31")
	public String update31(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			AdminUtil.updateFile2(request,"/files/three", "3_1.pdf");
			return "jsp/3_1";
		}
		return null;
	}
	
	@RequestMapping(value="update32")
	public String update32(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			AdminUtil.updateFile2(request,"/files/three", "3_2.pdf");
			return "jsp/3_2";
		}
		return null;
	}
	
	@RequestMapping(value="update44")
	public String update44(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			AdminUtil.updateFile2(request,"/files/four","jiaocai.pdf");
			return "jsp/4_4";
		}
		return null;
	}
	
	@RequestMapping(value="to4_1")
	public String to4_1(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/4_1";
		}
		return null;
	}
	
	@RequestMapping(value="to4_1_1a")
	public ModelAndView to4_1_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("课件");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/4_1_1a");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="uploade4_1")
	public ModelAndView uploade4_1(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/four/kejian";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("课件", name, select, path);
			mv.setViewName("/jsp/4_1");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile4_1_1a")
	public ModelAndView deletefile4_1_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/4_1_1a");
			mv.setViewName("redirect:/admin/to4_1_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to4_2")
	public String to4_2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/4_2";
		}
		return null;
		
	}
	
	@RequestMapping(value="to4_2_1a")
	public ModelAndView to4_2_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("电子教案");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/4_2_1a");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="uploade4_2")
	public ModelAndView uploade4_2(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/four/jiaoan";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("电子教案", name, select, path);
			mv.setViewName("/jsp/4_2");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile4_2_1a")
	public ModelAndView deletefile4_2_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/4_2_1a");
			mv.setViewName("redirect:/admin/to4_2_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to4_3")
	public String to4_3(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/4_3";
		}
		return null;
	}
	
	@RequestMapping(value="to4_3_1a")
	public ModelAndView to4_3_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("视频");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/4_3_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="uploade4_3")
	public ModelAndView uploade4_3(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/four/video";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("视频", name, select, path);
			mv.setViewName("/jsp/4_3");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile4_3_1a")
	public ModelAndView deletefile4_3_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/4_3_1a");
			mv.setViewName("redirect:/admin/to4_3_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to4_4")
	public String to4_4(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/4_4";
		}
		return null;
	}
	
	@RequestMapping(value="to5_1")
	public String to5_1(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/5_1";
		}
		return null;
	}
	
	@RequestMapping(value="to5_1_1a")
	public ModelAndView to5_1_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("实验指导书");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/5_1_1a");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="uploade5_1")
	public ModelAndView uploade5_1(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/five/zhidao";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("实验指导书", name, select, path);
			mv.setViewName("/jsp/5_1");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile5_1_1a")
	public ModelAndView deletefile5_1_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/4_1_1a");
			mv.setViewName("redirect:/admin/to5_1_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to5_2")
	public String to5_2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/5_2";
		}
		return null;
	}
	
	@RequestMapping(value="to5_2_1a")
	public ModelAndView to5_2_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("虚拟仿真");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/5_2_1a");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="uploade5_2")
	public ModelAndView uploade5_2(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/five/xuni";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("虚拟仿真", name, select, path);
			mv.setViewName("/jsp/5_2");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile5_2_1a")
	public ModelAndView deletefile5_2_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/4_1_1a");
			mv.setViewName("redirect:/admin/to5_2_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to5_3")
	public String to5_3(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/5_3";
		}
		return null;
	}
	
	@RequestMapping(value="to5_3_1a")
	public ModelAndView to5_3_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("matlab仿真");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/5_3_1a");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="uploade5_3")
	public ModelAndView uploade5_3(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/five/matlab";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("matlab仿真", name, select, path);
			mv.setViewName("/jsp/5_3");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile5_3_1a")
	public ModelAndView deletefile5_3_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/4_1_1a");
			mv.setViewName("redirect:/admin/to5_3_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to6_1")
	public String to6_1( HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/6_1";
		}
		return null;
	}
	
	@RequestMapping(value="to6_1_1a")
	public ModelAndView to6_1_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("习题");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/6_1_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="uploade6_1")
	public ModelAndView uploade6_1(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/six/Exercise";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("习题", name, select, path);
			mv.setViewName("/jsp/6_1");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile6_1_1a")
	public ModelAndView deletefile6_1_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/6_1_1a");
			mv.setViewName("redirect:/admin/to6_1_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to6_2")
	public String to6_2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/6_2";
		}
		return null;
	}
	
	@RequestMapping(value="to6_2_1a")
	public ModelAndView to6_2_1a(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			List<TeachResource> resource = (List<TeachResource>) teachResourceService.selAll("试题");
			mv.addObject("resource", resource);
			mv.setViewName("/jsp/6_2_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="uploade6_2")
	public ModelAndView uploade6_2(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			String select = request.getParameter("select");
			System.out.println(select);
			String path = "/files/six/Test";
			String name = AdminUtil.uplodeFile(request, path);
			select = AdminUtil.belong;
			System.out.println(name);
			teachResourceService.insert("试题", name, select, path);
			mv.setViewName("/jsp/6_2");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="deletefile6_2_1a")
	public ModelAndView deletefile6_2_1a(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			ModelAndView mv = new ModelAndView();
			String type = request.getParameter("type");
			String path = request.getParameter("path");
			String name = request.getParameter("name");
			System.out.println("路径："+path+"   文件名称："+name+"   文件类型："+type);
//			String path2 = request.getServletContext().getRealPath(path)+ "\\"+"login.jpg";
//			System.out.println(path2);
			AdminUtil.deleteFile(request, type, name, path);
			teachResourceService.delete(type, name, path);
//			mv.setViewName("/jsp/6_2_1a");
			mv.setViewName("redirect:/admin/to6_2_1a");
			return mv;
		}
		return null;
		
	}
	
	@RequestMapping(value="to7_1")
	public String to7_1( HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
			return "/jsp/7_1";
		}
		return null;
	}
	
	@RequestMapping(value="to7_1_1a")
	public ModelAndView to7_1_1a( HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		ModelAndView mv = new ModelAndView();
		if(admin!=null) {
			List<Picture> pictures = pictureService.selAll();
			for (Picture picture : pictures) {
				System.out.println(picture.toString());
			}
			mv.addObject("pictures", pictures);
			mv.setViewName("/jsp/7_1_1a");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="uploade7_1")
	public ModelAndView uploade7_1(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin!=null) {
//			String index = request.getParameter("select");
//			System.out.println(index);
			String path = "/img/lunbo";
			String name = AdminUtil.uplodeFile(request, path);
			String index;
			index = AdminUtil.belong;
			System.out.println(index);
			System.out.println(name);
			Picture picture = pictureService.selectPicture(index);
			AdminUtil.deleteFile(request, picture.getxu(), picture.getName(), picture.getPath());
			pictureService.updatePicture(name, index);
			mv.setViewName("/jsp/7_1");
			return mv;
		}
		return null;
		
	}
	
}
