package com.tonic.web.service.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonic.web.dao.QuoteDAO;
import com.tonic.web.dao.jdbc.JDBCQuoteDAO;
import com.tonic.web.entity.QuoteVO;
import com.tonic.web.service.QuoteService;

@Service
public class JDBCQuoteService implements QuoteService{
	@Autowired
	private QuoteDAO quoteDAO;

	public void setQuoteDAO(JDBCQuoteDAO quoteDAO) {
		this.quoteDAO = quoteDAO;
	}


	@Override
	public QuoteVO getRandomQuote() {
		
		int maxId = 0;
		maxId = quoteDAO.getLastId();
		QuoteVO quoteVO = quoteDAO.getRandomQuote(maxId);
		
		return quoteVO;
	}


	@Override
	public List<QuoteVO> getAllQuotes() {
		List<QuoteVO> quoteList = quoteDAO.getAllQuotes();
		return quoteList;
	}


	@Override
	public List<QuoteVO> searchQuotes(String keyword, String option) {
		List<QuoteVO> quoteList = quoteDAO.searchQuotes(keyword, option);
		return quoteList;
	}


	@Override
	public void delQuote(String keyword) {
		quoteDAO.delQuote(keyword);
		quoteDAO.sortId();
	}
	
	
	

}
