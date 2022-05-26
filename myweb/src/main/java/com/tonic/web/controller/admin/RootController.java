package com.tonic.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tonic.web.dao.NavListDAO;
import com.tonic.web.entity.ParentMenu;
import com.tonic.web.entity.QuoteVO;
import com.tonic.web.service.QuoteService;

@Controller
@RequestMapping("/admin/config/root/")
public class RootController {
	@Autowired
	private NavListDAO navListDAO;
	@Autowired
	private QuoteService quoteService;
	
	@RequestMapping("list")
	public ModelAndView list() {
//		네비게이션 리스트 모델
		List<ParentMenu> navList = navListDAO.getNavList("root");
		ModelAndView mv = new ModelAndView("config.root.list");
		mv.addObject("navList", navList);
		
		for(int i=0; i<navList.size(); i++) {
			System.out.println(navList.get(i));
		}
		
//		명언리스트 모델
		List<QuoteVO> quoteList = quoteService.getAllQuotes();
		mv.addObject("quoteList", quoteList);
		return mv;
	}
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("config.root.list");
		return mv;
	}
}
