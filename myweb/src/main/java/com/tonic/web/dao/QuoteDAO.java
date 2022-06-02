package com.tonic.web.dao;

import java.util.List;

import com.tonic.web.entity.QuoteVO;

public interface QuoteDAO {
	
	public int getLastId();													//	명언의 총 갯수 반환
	public QuoteVO getRandomQuote(int maxId);								// 	랜덤한 명언 반환
	public List<QuoteVO> getAllQuotes();									// 	모든 명언 반환
	public List<QuoteVO> searchQuotes(String keyword, String option);		// 	검색한 명언 반환
	
	public void sortId();													//	id 정렬
	public void delQuote(String keyword);									//  멍언 삭제
}
