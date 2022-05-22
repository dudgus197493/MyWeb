package com.tonic.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonic.web.entity.QuoteVO;

@Service
public class QuoteDAO {
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public int getLastId() {												// DB에 등록된 인용구의 총 갯수 구하기
		String query = "SELECT MAX(id) AS id FROM t_quote";
		int maxId = 0;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			rs.next();
			maxId = rs.getInt("id");
			System.out.println(maxId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return maxId;
	}
	public QuoteVO getRandomQuote(int maxId) {								// DB에 등록된 인용구중 랜덤으로 한 개 구하기
		String query = "SELECT * FROM t_quote WHERE id = ?";
		QuoteVO quoteVO = new QuoteVO();
		int randomId = (int)(Math.random() * maxId + 1);					// 랜덤으로 불러올 quote 아이디번호 설정
		System.out.println(query);
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, randomId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				quoteVO.setId(rs.getInt("id"));
				quoteVO.setEngContent(rs.getString("engContent"));
				quoteVO.setKorContent(rs.getString("korContent"));
				quoteVO.setSource(rs.getString("source"));
				System.out.println(quoteVO);
			} else {
				System.out.println("해당 번호의 인용구를 찾지 못했습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quoteVO;
	}
}
