package com.greedy.section01.crud.controller;

import java.util.List;
import java.util.Map;

import com.greedy.section01.crud.model.dto.MenuDTO;
import com.greedy.section01.crud.model.service.MenuService;
import com.greedy.section01.crud.view.CreateMenuResultView;
import com.greedy.section01.crud.view.MenuListView;

/* Contorller가 해야 할 일
 * 1. 화면으로부터 데이터 전달 받기
 * 2. 입력된 값 확인 및 검증
 * 3. 비지니스로직(서비스)로 전달하기 위한 값 가공
 * 4. 서비스 로직 호출
 * 5. 서비스 리턴 값을 활용해서 사용자 화면 연결
 * */

public class MenuController {
	
	private MenuService menuService = new MenuService();
	private MenuListView menuListView = new MenuListView();
	
	public void createNewMenu(Map<String, String> menuInfo) {
		
		System.out.println(menuInfo);
		
		MenuDTO menu = new MenuDTO();
		menu.setName(menuInfo.get("menuName"));
		menu.setPrice(Integer.parseInt(menuInfo.get("menuPrice")));
		menu.setCategoryCode(Integer.parseInt(menuInfo.get("categoryCode")));
		menu.setOrderableStatus(menuInfo.get("orderableStatus"));

		System.out.println(menu);
		
		MenuService menuService = new MenuService();
		boolean isCreated = menuService.createNewMenu(menu);
		
		CreateMenuResultView createResultView = 
				new CreateMenuResultView();
		if(isCreated) {
			createResultView.success();
		} else {
			createResultView.fail();
		}
	}
	
	public void findAllMenus() {
		
		List<MenuDTO> menuList = menuService.findAllMenus();
		
		if(menuList != null) {
			menuListView.printMenuList(menuList);
			
		} else {
			menuListView.showErrorView();
		}
	}
	
	
}
