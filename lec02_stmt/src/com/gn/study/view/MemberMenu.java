package com.gn.study.view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public void mainMenu() {
		while (true) {
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");

			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 0:
				System.out.println("잘가요~안녕~");
				sc.close();
				return;
			case 1:
				createMember();
				break;
			case 2:
				selectMemberAll();
				break;
			case 3:
				searchMemberOneById();
				break;
			case 4:
				serchMemberKeyword();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			default:
				System.out.println("올바른 메뉴를 선택해주세요");
				continue;
			}
		}
	}

	public void deleteMember() {
		System.out.println("=== 회원 탈퇴 ===");
		System.out.print("탈퇴할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("탈퇴할 비밀번호 : ");
		String pw = sc.nextLine();

		Member m = mc.selectMemberForDelete(id, pw);
		if (m != null) {
			System.out.println("회원 정보 : " + m.getMemberId() + ", " + m.getMemberName());
			int result = mc.deleteMemberInfo(m.getMemberNo());
			if (result > 0) {
				System.out.println("탈퇴 성공");
			} else {
				System.out.println("탈퇴 실패");
			}
		} else {
			System.out.println("잘못된 아이디 혹은 비밀번호입니다.");
		}
	}

	// 회원 정보 수정
	public void updateMember() {
		// 관리자 -> 모든 회원 정보 수정
		// 사용자 -> 본인 정보만 수정
		System.out.println("=== 회원 정보 수정 ===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		Member m = mc.selectMemberOneByIdAndPw(id, pw);
		if (m != null) {
			System.out.println("회원 정보 : " + m.getMemberId() + ", " + m.getMemberName());
			// 이메일, 전화번호, 이름 -> 수정
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("전화번호 : ");
			String phone = sc.nextLine();
			System.out.print("이메일 : ");
			String email = sc.nextLine();
			int result = mc.updateMemberInfo(m.getMemberNo(), name, phone, email);
			if (result > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} else {
			System.out.println("잘못된 아이디 혹은 비밀번호입니다.");
		}
	}

	// 키워드로 회원 검색
	public void serchMemberKeyword() {
		System.out.println("=== 키워드 회원 검색 ===");
		System.out.print("키워드 : ");
		String keyword = sc.nextLine();
		List<Member> list = mc.selectMemberKeyword(keyword);
		if (list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다");
		} else {
			for (Member m : list) {
				System.out.println(m);
			}
		}
	}

	// 아이디 기준 회원 조회
	public void searchMemberOneById() {
		System.out.println("=== 회원 아이디 검색 ===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		// WHERE -> =(UNIQUE / X) / LIKE
		Member m = mc.selectMemberOneById(id);
		if (m != null) {
			System.out.println(m);
		} else {
			System.out.println("번호: " + m.getMemberNo() + ", ID: " + m.getMemberId() + ", 이름: " + m.getMemberName()
					+ ", 이메일: " + m.getMemberEmail() + ", 전화번호: " + m.getMemberPhone() + ", 성별: " + m.getMemberGender()
					+ ", 등록일: " + m.getRegDate().format(dtf) + ", 수정일: " + m.getModDate().format(dtf));
		}
	}

	// 전체 회원 조회
	public void selectMemberAll() {
		System.out.println("=== 회원 전체 조회 ===");
		List<Member> list = mc.seletMemberAll();
		// (1) 만약에 list가 비어있다면 -> 조회된 결과가 없습니다.
		// (2) Member 목록 출력
		if (list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다");
		} else {
			for (Member m : list) {
				System.out.println(
						"번호: " + m.getMemberNo() + ", ID: " + m.getMemberId() + ", 이름: " + m.getMemberName() + ", 이메일: "
								+ m.getMemberEmail() + ", 전화번호: " + m.getMemberPhone() + ", 성별: " + m.getMemberGender()
								+ ", 등록일: " + m.getRegDate().format(dtf) + ", 수정일: " + m.getModDate().format(dtf));
			}
		}
	}

	// 회원 정보 추가
	public void createMember() {
		System.out.println("=== 회원 정보 추가 ===");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String memberEmail = sc.nextLine();
		System.out.print("전화번호(-빼고 입력) : ");
		String memberPhone = sc.nextLine();
		System.out.print("성별 : ");
		String memberGender = sc.nextLine();

		int result = mc.insertMember(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		if (result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

	}
}