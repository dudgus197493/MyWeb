package com.tonic.web.dao;

import java.util.List;

import com.tonic.web.entity.QuoteVO;

public interface QuoteDAO {
	
	public int getLastId();													// ��� �� ���� ��ȯ
	public QuoteVO getRandomQuote(int maxId);								// ���� ��� �ϳ� ��ȯ
	public List<QuoteVO> getAllQuotes();									// ��� ��� ����Ʈ ��ȯ
	public List<QuoteVO> searchQuotes(String keyword, String option);		// ��� �˻� �� ����Ʈ�� ��ȯ
}
