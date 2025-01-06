package com.gn.homework.view;

import java.util.Scanner;

import com.gn.homework.controller.MenuController;
import com.gn.homework.model.vo.Menu;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	MenuController mc = new MenuController();

	public void MainMenu() {
		int menu = sc.nextInt();

		do {
			System.out.println("== Watermelon Music ==");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 종료");

			switch (menu) {
			case 1:
				signup();
				break;
			case 2:
				login();
				break;
			default:
				System.out.println("다시 입력");
				continue;
			}
		} while (menu == 0);
	}

	public void signup() {
		System.out.println("=== 회원가입 ===");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		int check = mc.checkId(id);
		if (check > 0) {
			System.out.println("아이디 생성이 가능합니다");
			System.out.println("비밀번호 : ");
			String pw = sc.nextLine();
			Menu m = mc.signup(id, pw);
			if (m != null) {
				System.out.println("계정 생성 완료");
				MainMenu();
			} else {
				System.out.println("계정 생성 실패");
			}
		} else {
			System.out.println("동일한 아이디가 존재합니다");
		}

	}

	private void login() {

	}
}
