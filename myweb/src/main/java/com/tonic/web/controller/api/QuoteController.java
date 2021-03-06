package com.tonic.web.controller.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonic.web.entity.QuoteVO;
import com.tonic.web.service.QuoteService;

@RestController("apiQuoteController")
@RequestMapping("/api/quote/")
public class QuoteController {
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping("list")
	public List<QuoteVO> list() {
		List<QuoteVO> quotelist = quoteService.getAllQuotes();
		System.out.println(quotelist);
		return quotelist;
	}
	@RequestMapping("random")
	public QuoteVO random() {
		QuoteVO quoteVO = quoteService.getRandomQuote();
		
		return quoteVO;
	}
	@RequestMapping("search")
	public List<QuoteVO> search(@RequestBody HashMap<String, String> input){
		String keyword = input.get("keyword");
		String option = input.get("option");
		System.out.printf("keyword = %s / option = %s", keyword, option);					// POST 인풋 데이터 확인 로그
		List<QuoteVO> quoteList = quoteService.searchQuotes(keyword, option);
		return quoteList;
	}
	@RequestMapping("del")
	public void del(@RequestBody HashMap<String, String> input) {
		String keyword = input.get("keyword");
		System.out.println(keyword);
		quoteService.delQuote(keyword);
	}
}
