package com.tonic.web.entity;

public class Menu {
	private int id;
	private String name;
	private String property;
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", property=" + property + "]";
	}
	public Menu(int id, String name, String property) {
		this.id = id;
		this.name = name;
		this.property = property;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
}
