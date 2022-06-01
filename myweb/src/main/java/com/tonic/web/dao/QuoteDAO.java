package com.tonic.web.dao;

import java.util.List;

import com.tonic.web.entity.QuoteVO;

public interface QuoteDAO {
	
	public int getLastId();													// 명언 총 갯수 반환
	public QuoteVO getRandomQuote(int maxId);								// 랜덤 명언 하나 반환
	public List<QuoteVO> getAllQuotes();									// 모든 명언 리스트 반환
	public List<QuoteVO> searchQuotes(String keyword, String option);		// 명언 검색 후 리스트로 반환
}
