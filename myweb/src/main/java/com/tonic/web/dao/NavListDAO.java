package com.tonic.web.dao;

import java.util.List;

import com.tonic.web.entity.ParentMenu;

public interface NavListDAO {
	public List<ParentMenu> getNavList(String page);
}
