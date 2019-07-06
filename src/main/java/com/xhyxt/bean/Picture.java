package com.xhyxt.bean;

public class Picture {
	private String name;
	private String path;
	private String xu;
	private String type;
	public Picture(String name, String path, String xu, String type) {
		super();
		this.name = name;
		this.path = path;
		this.xu = xu;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getxu() {
		return xu;
	}
	public void setxu(String xu) {
		this.xu = xu;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Picture [name=" + name + ", path=" + path + ", xu=" + xu + ", type=" + type + "]";
	}
	
	
}
