package com.tonic.web.entity;

import java.util.ArrayList;
import java.util.List;

public class ParentMenu {
	private String name;
	private List<Menu> menuList = new ArrayList<Menu>();
	
	public ParentMenu(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addMenu(Menu menu) {
		this.menuList.add(menu);
	}
	public List<Menu> getMenuList(){
		return this.menuList;
	}

	@Override
	public String toString() {
		return "ParentMenu [name=" + name + ", menuList=" + menuList + "]";
	}
	
}
