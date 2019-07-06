package com.xhyxt.bean;

public class TeachResource {
	private String name;
	private String type;
	private String section;
	private String path;
	
	public TeachResource(String name, String type, String section, String path) {
		super();
		this.name = name;
		this.type = type;
		this.section = section;
		this.path = path;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "TeachResource [name=" + name + ", type=" + type + ", section=" + section + ", path=" + path + "]";
	}
	
	
}
