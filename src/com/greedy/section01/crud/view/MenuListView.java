package com.greedy.section01.crud.view;

import java.util.List;

import com.greedy.section01.crud.model.dto.MenuDTO;

public class MenuListView {
	
	public void printMenuList(List<MenuDTO> menuList) {
		for (MenuDTO menu : menuList) {
			System.out.println(menu);
		}
	}
	
	public void showErrorView() {
		System.out.println("메뉴 목록 조회 실패!");
	}
}
