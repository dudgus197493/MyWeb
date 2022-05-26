package com.tonic.web.service;

import java.util.List;

import com.tonic.web.entity.QuoteVO;

public interface QuoteService {
	public QuoteVO getRandomQuote();
	public List<QuoteVO> getAllQuotes();
}
