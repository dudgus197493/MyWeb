package com.tonic.web.dao;

import java.util.List;

import com.tonic.web.entity.QuoteVO;

public interface QuoteDAO {
	
	public int getLastId();
	public QuoteVO getRandomQuote(int maxId);
	public List<QuoteVO> getAllQuotes();
	public List<QuoteVO> searchQuotes(String keyword, String option);
}
