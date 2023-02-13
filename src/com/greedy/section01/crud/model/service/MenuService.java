package com.greedy.section01.crud.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.section01.crud.model.dao.MenuDAO;
import com.greedy.section01.crud.model.dto.MenuDTO;

/* Service 클래스에서 할 일
 * 1. Connection 생성
 * 2. DAO 호출하면서 Connection과 Controller로 부터 밭은 값 전달
 * 3. 트랜젝션 제어
 * 4. Connection 닫기
 * 5. Controller로 결과 응답
 * */

public class MenuService {
	
	private MenuDAO menuDAO = new MenuDAO();
	
	public boolean createNewMenu(MenuDTO menu) {
		
		Connection con = getConnection();
		
		MenuDAO menuDAO = new MenuDAO();
		int result = menuDAO.insertNewMenu(con, menu);
		
		if(result > 0 ) {
				commit(con);
		} else {
				rollback(con);
		}
		
		close(con);
		
		return result > 0 ? true : false;

	}
	
	public List<MenuDTO> findAllMenus() {
		
		Connection con = getConnection();
		
		List<MenuDTO> menuList = menuDAO.selectMenuList(con);
		
		close(con);

		return menuList;
	}
}
