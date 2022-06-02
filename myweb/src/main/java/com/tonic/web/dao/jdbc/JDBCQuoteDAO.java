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
	public int getLastId() {												// DB�� ��ϵ� �ο뱸�� �� ���� ���ϱ�
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
	public QuoteVO getRandomQuote(int maxId) {								// DB�� ��ϵ� �ο뱸�� �������� �� �� ���ϱ�
		final String QUERY = "SELECT * FROM t_quote WHERE id = ?";
		int randomId = (int)(Math.random() * maxId + 1);					// �������� �ҷ��� quote ���̵��ȣ ����
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
				System.out.println("�ش� ��ȣ�� �ο뱸�� ã�� ���߽��ϴ�.");
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
	public List<QuoteVO> searchQuotes(String keyword, String option){						// option ['Ű����', 'ī�װ�', '�ҽ�']
		String query;
		if(option.equals("1")) {												// Ű����
			query = "SELECT * FROM t_quote WHERE korContent LIKE CONCAT('%',?,'%') OR engContent LIKE CONCAT('%',?,'%')";
		} else if (option.equals("2")) {										// ī�װ�
			query = "SELECT * FROM t_quote WHERE category LIKE CONCAT('%',?,'%')";
		} else {																// ��ó��
			query = "SELECT * FROM t_quote WHERE source LIKE CONCAT('%',?,'%')";
		}
		
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			if(option.equals("1")) {
				pstmt.setString(1, keyword);
				pstmt.setString(2, keyword);
			} else {
				pstmt.setString(1, keyword);
			}
			ResultSet rs = pstmt.executeQuery();
			List<QuoteVO> quoteList = returnQuoteList(rs);
//			for(int i=0; i<quoteList.size(); i++) {				���ϰ� �α� Ȯ��
//				System.out.println(quoteList.get(i));
//			}
			return quoteList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	private List<QuoteVO> returnQuoteList(ResultSet rs) throws SQLException {
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
	@Override
	public void delQuote(String keyword) {
		final String QUERY = "DELETE FROM t_quote WHERE engContent = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.setString(1, keyword);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delQuote에서 예외 발생!");
			e.printStackTrace();
		}	
	}
	@Override
	public void sortId() {
		final String QUERY = "CALL sortID()";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sortId에서 예외 발생!");
			e.printStackTrace();
		}
	}
}
