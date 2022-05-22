package com.tonic.web.service.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonic.web.dao.QuoteDAO;
import com.tonic.web.entity.QuoteVO;
import com.tonic.web.service.QuoteService;

@Service
public class JDBCQuoteService implements QuoteService{
	@Autowired
	private QuoteDAO quoteDAO;

	public void setQuoteDAO(QuoteDAO quoteDAO) {
		this.quoteDAO = quoteDAO;
	}


	@Override
	public QuoteVO getRandomQuote() {
		
		int maxId = 0;
		maxId = quoteDAO.getLastId();
		QuoteVO quoteVO = quoteDAO.getRandomQuote(maxId);
		
		return quoteVO;
	}

}