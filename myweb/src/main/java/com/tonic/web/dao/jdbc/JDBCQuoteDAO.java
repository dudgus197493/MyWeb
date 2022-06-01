package com.tonic.web.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonic.web.dao.QuoteDAO;
import com.tonic.web.entity.QuoteVO;

@Service
public class JDBCQuoteDAO implements QuoteDAO{
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public int getLastId() {												// DB에 등록된 인용구의 총 갯수 구하기
		final String QUERY = "SELECT MAX(id) AS id FROM t_quote";
		int maxId = 0;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery(QUERY);
			rs.next();
			maxId = rs.getInt("id");
			System.out.println(maxId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return maxId;
	}
	public QuoteVO getRandomQuote(int maxId) {								// DB에 등록된 인용구중 랜덤으로 한 개 구하기
		final String QUERY = "SELECT * FROM t_quote WHERE id = ?";
		int randomId = (int)(Math.random() * maxId + 1);					// 랜덤으로 불러올 quote 아이디번호 설정
		System.out.println(randomId);
		QuoteVO quoteVO;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.setInt(1, randomId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				quoteVO = new QuoteVO(
						rs.getInt("id"),
						rs.getString("engContent"),
						rs.getString("korContent"),
						rs.getString("source"),
						rs.getString("category")
						);
//				quoteVO.setId(rs.getInt("id"));
//				quoteVO.setEngContent(rs.getString("engContent"));
//				quoteVO.setKorContent(rs.getString("korContent"));
//				quoteVO.setSource(rs.getString("source"));
//				System.out.println(quoteVO);
				return quoteVO;
			} else {
				System.out.println("해당 번호의 인용구를 찾지 못했습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<QuoteVO> getAllQuotes() { 
		final String QUERY = "SELECT * FROM t_quote";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			List<QuoteVO> quoteList = returnQuoteList(rs);
//			while(rs.next()) {
//				QuoteVO quoteVO = new QuoteVO(
//						rs.getInt("id"),
//						rs.getString("engContent"),
//						rs.getString("korContent"),
//						rs.getString("source"),
//						rs.getString("category")
//						);
//				quoteList.add(quoteVO);
//			}
			return quoteList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QuoteVO> searchQuotes(String keyword, String option){
		String query;
		if(option == "1") {
			query = "";
		} else if (option == "2") {
			query = "";
		} else if (option == "3") {
			query = "";
		}
		return null;
	}
	
	
	public List<QuoteVO> returnQuoteList(ResultSet rs) throws SQLException {
		List<QuoteVO> quoteList = new ArrayList<QuoteVO>();
		while(rs.next()) {
			QuoteVO quoteVO = new QuoteVO(
					rs.getInt("id"),
					rs.getString("engContent"),
					rs.getString("korContent"),
					rs.getString("source"),
					rs.getString("category")
					);
			quoteList.add(quoteVO);
		}
		return quoteList;
	}
}
