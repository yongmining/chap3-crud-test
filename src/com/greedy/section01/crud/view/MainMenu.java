package com.greedy.section01.crud.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.greedy.section01.crud.controller.MenuController;
	
public class MainMenu {
	
	public void displayMenu() {
		
		Scanner sc = new Scanner(System.in);
		MenuController menuController =  new MenuController();
		do {
			System.out.println("====== GREEDY RESTOURANT =====");
			System.out.println("1. 전체 메뉴 조회");
			System.out.println("2. 메뉴 상세 조회");
			System.out.println("3. 신규 메뉴 둥록");
			System.out.println("4. 메뉴 정보 변경");
			System.out.println("5. 메뉴 삭제");
			System.out.println("==============================");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : menuController.findAllMenus(); break;
			case 2 : break;
			case 3 : menuController.createNewMenu(inputNewMenu()); break;
			case 4 : break;
			case 5 : break;
			case 9 : System.out.println("프로그램을 종료합니다."); break;
			}
			
		} while(true);
	}
	private Map<String, String> inputNewMenu() {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("등록할 메뉴의 이름을 입력해주세요 : ");
	String menuName = sc.nextLine();
	System.out.print("등록할 메뉴의 가격을 입력해주세요 : ");
	String menuPrice = sc.nextLine();
	System.out.print("등록할 카테고리의 코드를 입력해주세요 : ");
	String categoryCode = sc.nextLine();
	System.out.print("판매 여부를 결정해주세요(Y/N) : ");
	String orderableStatus = sc.nextLine();
	
	Map<String, String> menuInfo = new HashMap<>();
	menuInfo.put("menuName", menuName);
	menuInfo.put("menuPrice", menuPrice);
	menuInfo.put("categoryCode", categoryCode);
	menuInfo.put("orderableStatus", orderableStatus);
	
	return menuInfo;
	
	}
	
	
}
