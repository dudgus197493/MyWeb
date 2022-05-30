package com.tonic.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<QuoteVO> getAllQuotes() {
		List<QuoteVO> quotelist = quoteService.getAllQuotes();
		System.out.println(quotelist);
		return quotelist;
	}
	@RequestMapping("random")
	public QuoteVO getRandomQuote() {
		QuoteVO quoteVO = quoteService.getRandomQuote();
		
		return quoteVO;
	}
}
