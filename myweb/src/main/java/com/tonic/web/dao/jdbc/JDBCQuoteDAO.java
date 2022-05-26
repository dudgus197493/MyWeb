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
		System.out.println(QUERY);
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
						rs.getString("source")
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
		List<QuoteVO> quoteList = new ArrayList<QuoteVO>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				QuoteVO quoteVO = new QuoteVO(
						rs.getInt("id"),
						rs.getString("engContent"),
						rs.getString("korContent"),
						rs.getString("source")
						);
				quoteList.add(quoteVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quoteList;
	}
}
