package com.tonic.web.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tonic.web.entity.QuoteVO;
import com.tonic.web.service.QuoteService;


@Controller
@RequestMapping("/")
public class HomeController{
	@Autowired
	private QuoteService quoteService;
	
	@RequestMapping("index")
	@ResponseBody
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("root.root");
		QuoteVO quoteVO = quoteService.getRandomQuote();
		mv.addObject("quote", quoteVO);
		return mv;
	}
	
	@RequestMapping("admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView("admin.main");
		System.out.println("admin page request!!");
		return mv;
		
	}
	
// 	���� �������� @Autowired�� ��ü �Ҵ��� �Ͽ��⶧���� �����ڰ� �ʿ����
//	public void setQuoteService(QuoteService quoteService) {
//		this.quoteService = quoteService;
//	}
	
	
	
	
	
	
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("indexController!");
//		QuoteVO quoteVO = quoteService.getRandomQuote();
//		ModelAndView mv = new ModelAndView("root.index");
//		mv.addObject("quote", quoteVO);
//		return mv;
//		
//	}

}
