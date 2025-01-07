package com.gn.homework.view;

import java.util.Scanner;

import com.gn.homework.controller.MarketController;
import com.gn.homework.model.vo.MarketVo;

public class MarketMenu {
	Scanner sc = new Scanner(System.in);
	MarketController mc = new MarketController();

	// 회원가입, 로그인

	// 관리자 계정으로 로그인시 관리자 메뉴
	// 제품등록 제품입고 판매현황

	// 일반 계정 로그인시 사용자 메뉴
	// 제품구매 개인정보수정 탈퇴
	public void mainMenu() {

		int menu = 0;
		while (true) {
			System.out.println("+++ super market +++");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 종료");
			System.out.print("메뉴 입력 : ");
			menu = sc.nextInt();

			sc.nextLine();

			switch (menu) {
			case 1:
				signup();
				break;
			case 2:
				login();
				break;
			case 0:
				System.out.println("종료되었습니다.");
				return;
			default:
				System.out.println("번호 입력 오류");
			}
		}
	}

	private void login() {
		System.out.println("+++ 로그인 +++");
		String id = null;
		String pw = null;
		while (true) {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			System.out.print("비밀번호 : ");
			pw = sc.nextLine();
			MarketVo vo = mc.checkIdPw(id, pw);
		}
	}

	private void signup() {
		System.out.println("+++ 회원가입 +++");
		String id = null;
		while (true) {
			System.out.print("아이디 입력 : ");
			id = sc.nextLine();
			MarketVo vo = mc.checkId(id);
			if (vo != null) {
				System.out.println("이미 존재하는 아이디입니다.");
			} else {
				break;
			}
		}
		System.out.print("비밀번호 입력 : ");
		String pw = sc.nextLine();
		System.out.print("닉네임 입력 : ");
		String name = sc.nextLine();
		int result = mc.signup(id, pw, name);
		if (result > 0)
			System.out.println("가입완료");
		else
			System.out.println("가입실패");
	}

}
