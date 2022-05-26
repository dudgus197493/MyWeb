package com.tonic.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tonic.web.dao.jdbc.JDBCNavListDAO;
import com.tonic.web.entity.ParentMenu;

@Controller
@RequestMapping("/admin/config/")
public class AdminController {								// [Todo]RootController �� �ٲٰ� list, addQuote, delQuote �Լ� ����
	
	@Autowired
	private JDBCNavListDAO navListDAO;
	
	@RequestMapping("*")
	public ModelAndView root(HttpServletRequest request) {		
		//		�׺���̼� ����Ʈ ��
		String url = request.getRequestURI();
		String lastSegment = url.substring(url.lastIndexOf("/") + 1);
		System.out.println(url);
		System.out.println(lastSegment);
		List<ParentMenu> navList = navListDAO.getNavList(lastSegment);
		ModelAndView mv = new ModelAndView("config.root");
		mv.addObject("navList", navList);
		//		��𸮽�Ʈ ��
		
		
		for(int i=0; i<navList.size(); i++) {
			System.out.println(navList.get(i));
		}
		
		return mv;
	}
	@RequestMapping("root/quote")
	public void test() {
		System.out.println("quoteâ");
	}
}
