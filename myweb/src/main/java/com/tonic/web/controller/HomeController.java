package com.tonic.web.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tonic.web.entity.QuoteVO;
import com.tonic.web.service.QuoteService;


@Controller
@RequestMapping("/")
public class HomeController{
	@Autowired
	private QuoteService quoteService;
	
	@RequestMapping("index")
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
	
	
	
	
	@RequestMapping("test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView("root.test");
		
		return mv;
	}
	
// 	선언 과정에서 @Autowired로 객체 할당을 하였기때문에 생정자가 필요없음
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
