package com.tonic.web.service;

import java.util.List;

import com.tonic.web.entity.QuoteVO;

public interface QuoteService {
	public QuoteVO getRandomQuote();									// 	랜덤한 명언 반환
	public List<QuoteVO> getAllQuotes();                                // 	모든 명언 반환 
	public List<QuoteVO> searchQuotes(String keyword, String option);   // 	검색한 명언 반환
	public void delQuote(String keyword);								//  명언 삭제
}                                                                         
