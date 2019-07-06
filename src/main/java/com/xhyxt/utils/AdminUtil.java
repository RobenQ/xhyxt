package com.xhyxt.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class AdminUtil {
	public static String belong;
	/**
	 * 
	 * @param password 从jsp页面获取的用户输入的未加密明文
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String sHAEncrypt(String password) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA");
		String value = password;
		//int a = Integer.parseInt(value);
		//byte b = (byte) a;
		byte[] inpute = value.getBytes();
		mDigest.update(inpute);        //input可以是字节型或字节型数组
		String key = new BigInteger(mDigest.digest()).toString();
		return key;
	}
	
	/**
	 * 此方法用于配和前端jsp用于Ajax传递读取静态HTML等网页格式的文件
	 * @param request 请求request
	 * @param response 请求response
	 * @param filePath 文件项目根目录下的路径，注意路径前后添加“/”符号
	 * @param fileName 文件名称，传参时注意写上“.”+后缀名
	 * @throws IOException
	 */
	public static void readFile(HttpServletRequest request,HttpServletResponse response,String filePath,String fileName) throws IOException {
		response.setContentType("text/html;charset=utf_8");
		InputStream in = new FileInputStream(request.getServletContext().getRealPath(filePath)+fileName);
		System.out.println(request.getServletContext().getRealPath(filePath)+fileName);
		int len = 0;
         //5.创建数据缓冲区
         byte[] buffer = new byte[1024];
         //6.通过response对象获取OutputStream流
         OutputStream out = response.getOutputStream();
        //7.将FileInputStream流写入到buffer缓冲区
         while ((len = in.read(buffer)) > 0) {
         //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
             out.write(buffer,0,len);
         }
         in.close();
	}
	
	/**
	 * 管理员上传教学资源通用工具
	 * @param request 请求request
	 * @param uploadPath 文件上传文件夹路径（除了项目根目录之后的路径），路径前加“/”符号
	 */
	public static String uplodeFile(HttpServletRequest request,String uploadPath) {
		String filePath;//文件上传后的路径
		String name = null;
		// 判断表单的enctype值是不是"multipart/form-data"
        boolean isMultipartContent = ServletFileUpload
                .isMultipartContent(request);
        if (!isMultipartContent) {
            throw new RuntimeException("your form is not multipart/form-data");
        }
        // 创建一个DiskFileItemfactory工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 创建一个ServletFileUpload核心对象
        ServletFileUpload sfu = new ServletFileUpload(factory);
        // 解析request对象，并得到一个表单项的集合
        try {
            List<FileItem> fileItems = sfu.parseRequest(request);
            // 遍历表单项数据
            for (FileItem fileitem : fileItems) {
                if (fileitem.isFormField()) {
                    // 普通表单项
                    String fieldName = fileitem.getString("UTF-8");
                    String fieldValue = fileitem.getString("UTF-8");
                    belong = fieldName;
                    System.out.println(fieldName + "=====" + fieldValue);
                } else {
                    //上传表单项
                    //得到文件输入流
                    InputStream is = fileitem.getInputStream();
                    //创建文件存储目录
                    String directoryRealPath = request.getServletContext().getRealPath(uploadPath);
                    System.out.println(directoryRealPath);
                    System.out.println(fileitem.getName());
                    String[] str = fileitem.getName().split("\\\\");
                    String fileName = str[str.length-1];
                    name = fileName;
                    System.out.println(fileName);
                    File storeDirectory = new File(directoryRealPath + "/"+fileName);
                    System.out.println(directoryRealPath +  "\\"+fileName);
                    filePath = directoryRealPath +  "\\"+fileName;
                    //使用apache commons-io包，将输入流转成文件
                    FileUtils.copyInputStreamToFile(is, storeDirectory);
                    Thread.sleep(1000);
                    return name;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件更上传失败！");
        }
        return name;
	}
	
	/**
	 * 此方法用于上传课程概况以及教学队伍相关资源
	 * @param request 请求request
	 * @param updateFileName 上传的文件名，注意：文件名后需要加上“.”+后缀
	 */
	public static void updateFile2(HttpServletRequest request,String filePath,String updateFileName) {
		// 判断表单的enctype值是不是"multipart/form-data"
        boolean isMultipartContent = ServletFileUpload
                .isMultipartContent(request);
        if (!isMultipartContent) {
            throw new RuntimeException("your form is not multipart/form-data");
        }
        // 创建一个DiskFileItemfactory工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 创建一个ServletFileUpload核心对象
        ServletFileUpload sfu = new ServletFileUpload(factory);
        // 解析request对象，并得到一个表单项的集合
        try {
            List<FileItem> fileItems = sfu.parseRequest(request);
            // 遍历表单项数据
            for (FileItem fileitem : fileItems) {
                if (fileitem.isFormField()) {
                    // 普通表单项
                    String fieldName = fileitem.getString("UTF-8");
                	String fileName = updateFileName;
                    String fieldValue = fileitem.getString("UTF-8");
                    System.out.println(fieldName + "=====" + fieldValue);
                } else {
                    //上传表单项
                    //得到文件输入流
                	//String fileName = updateFileName;
                    InputStream is = fileitem.getInputStream();
                    //创建文件存储目录
                    String directoryRealPath = request.getServletContext().getRealPath(filePath);
                    System.out.println(directoryRealPath);
                    System.out.println(fileitem.getName());
                    String[] str = fileitem.getName().split("\\\\");
                    String fileName = str[str.length-1];
                    System.out.println(fileName);
                    File storeDirectory = new File(directoryRealPath + "/"+updateFileName);
                    System.out.println(directoryRealPath +  "/"+updateFileName);
//                    if(storeDirectory.exists()) {
//                    	storeDirectory.delete();
//                    }else {
                    	//使用apache commons-io包，将输入流转成文件
                        FileUtils.copyInputStreamToFile(is, storeDirectory);
//					}
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件更改失败！");
        }
	}
	
	public static void download(HttpServletRequest request, HttpServletResponse response,
			String filePath,String fileName,String filedisplay) throws IOException{ 
	    String basePath = request.getSession().getServletContext().getRealPath(filePath);
	    String filedownload = basePath + "/" + fileName;
//	    String filedownload = basePath + fileName;
	    String contentType = request.getServletContext().getMimeType(filedownload);
	    response.setHeader("Content-Type", contentType);
	    response.setHeader("Content-Disposition", "attachment;filename="+new String( filedisplay.getBytes("UTF-8"), "UTF-8" )); 
	      
	    InputStream is = null; 
	    OutputStream os = null; 
	    BufferedInputStream bis = null; 
	    BufferedOutputStream bos = null; 
	      
	    is = new FileInputStream(new File(filedownload)); 
	    bis = new BufferedInputStream(is); 
	    os = response.getOutputStream(); 
	    bos = new BufferedOutputStream(os); 
	      
	    byte[] b = new byte[1024]; 
	    int len = 0; 
	    while((len = bis.read(b)) != -1){ 
	      bos.write(b,0,len); 
	    } 
	      
	    bis.close(); 
	    is.close(); 
	    bos.close(); 
	    os.close(); 
	  }
	
	public static void deleteFile(HttpServletRequest request,String type,String name,String path) {
		String basePath = request.getSession().getServletContext().getRealPath(path);
		String filePath = basePath+"/"+name;
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
	}
	
//	public static String download(String filePath, HttpServletRequest request,HttpServletResponse response) {
//		try {
//			//获取文件名
//			String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
//			String[] str = filePath.split("\\\\");
//            String nameString = str[str.length-1];
//            System.out.println(fileName);
//			System.out.println(filePath);
//			System.out.println(nameString);
//			response.setContentType("application/x-download");//设置为下载application/x-download
//			System.out.println(request.getServletContext().getMimeType(filePath));
//			response.setCharacterEncoding("utf-8");
////			response.setContentType("multipart/form-data");
//			//处理下载弹出框名字的编码问题
//			response.setHeader("Content-Disposition", "attachment;fileName="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
//			//获取文件的下载路径
//			String path = filePath;
//			System.out.println(path);
//			//利用输入输出流对文件进行下载
//			InputStream inputStream = new FileInputStream(new File(path));
//
//			OutputStream os = response.getOutputStream();
//			byte[] b = new byte[2048];
//			int length;
//			while ((length = inputStream.read(b)) > 0) {
//				os.write(b, 0, length);
//			}
//			// 这里主要关闭。
//			os.close();
//
//			inputStream.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//  返回值要注意，要不然就出现下面这句错误！
//		//java+getOutputStream() has already been called for this response
//		return null;
//	}
//	
//	//下载
//	public static void douwnloadFile(HttpServletRequest request,HttpServletResponse response,String filePath,String fileName) throws IOException {
//		String mime = request.getServletContext().getMimeType(fileName);
//		response.setContentType("application/x-download");//设置为下载application/x-download
//		response.setHeader("content-disposition", "attachment;filename=" + fileName);
//		InputStream in = new FileInputStream(request.getServletContext().getRealPath(filePath)+fileName);
//		System.out.println(request.getServletContext().getRealPath(filePath)+fileName);
//		int len = 0;
//         //5.创建数据缓冲区
//         byte[] buffer = new byte[1024];
//         //6.通过response对象获取OutputStream流
//         OutputStream out = response.getOutputStream();
//        //7.将FileInputStream流写入到buffer缓冲区
//         while ((len = in.read(buffer)) > 0) {
//         //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
//             out.write(buffer,0,len);
//         }
//         in.close();
//         response.sendRedirect("/jsp/4_1_1.jsp");
//	}
}