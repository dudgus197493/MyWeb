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
				if(rs.getInt("level") == 1) {									// �ش� �÷��� level�� 1�̸� ParentMenu�� ������ �Ʒ� �ڵ� ����
					ParentMenu pm = new ParentMenu(rs.getString("name"));
					System.out.println(rs.getString("name"));
					while(rs.next()) {
						if(rs.getInt("level") == 2) {							// �ش� �÷��� level�� 2�̸� Menu��ü�� ������ ��� ������ ������ ParentMenu�� ���
							Menu menu = new Menu(rs.getInt("id"), rs.getString("name"), rs.getString("property"));
							System.out.println(menu);
							pm.addMenu(menu);
							if(rs.isLast()) {									// �ش� �÷��� ������ �÷��̶�� ���� �ֱ��� ������ ParentMenu�� navList�� ��� break
								navList.add(pm);
								break;
							}
						} else {												// �ش� �÷��� level�� �ٽ�2���Ǹ� ���� �ö󰡼� �ݺ�
							navList.add(pm);
							rs.previous();
							break;
						}
					}
				}else {
					System.out.println("level 2�Դϴ�");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return navList;
	}
}
