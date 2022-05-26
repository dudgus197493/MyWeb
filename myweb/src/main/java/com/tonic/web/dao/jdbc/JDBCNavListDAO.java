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

import com.tonic.web.dao.NavListDAO;
import com.tonic.web.entity.Menu;
import com.tonic.web.entity.ParentMenu;

@Service
public class JDBCNavListDAO implements NavListDAO{
	@Autowired
	private DataSource dataSource;
	
	public List<ParentMenu> getNavList(String page) {
		final String QUERY = "SELECT * FROM (SELECT * FROM t_cfg_navList WHERE page = ?) EX";
		List<ParentMenu> navList = new ArrayList<ParentMenu>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1, page);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("level") == 1) {									// 해당 컬럼의 level이 1이면 ParentMenu를 생성후 아래 코드 실행
					ParentMenu pm = new ParentMenu(rs.getString("name"));
					System.out.println(rs.getString("name"));
					while(rs.next()) {
						if(rs.getInt("level") == 2) {							// 해당 컬럼의 level이 2이면 Menu객체에 정보를 담고 위에서 생성한 ParentMenu에 담기
							Menu menu = new Menu(rs.getInt("id"), rs.getString("name"), rs.getString("property"));
							System.out.println(menu);
							pm.addMenu(menu);
							if(rs.isLast()) {									// 해당 컬럼이 마지막 컬럼이라면 가장 최근의 생성한 ParentMenu를 navList에 담고 break
								navList.add(pm);
								break;
							}
						} else {												// 해당 컬럼의 level이 다시2가되면 위로 올라가서 반복
							navList.add(pm);
							rs.previous();
							break;
						}
					}
				}else {
					System.out.println("level 2입니다");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return navList;
	}
}
