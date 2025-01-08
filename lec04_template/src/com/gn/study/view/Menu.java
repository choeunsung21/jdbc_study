package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

// 사용자가 보게 될 화면
// 사용자에게 정보 입력받기
// 결과 화면 출력
public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();

	public void mainMenu() {
		while (true) {
			System.out.println("=== 자동차 정보 관리 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");

			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				insertCarOne();
				break;
			case 2:
				selectCarAll();
				break;
			case 3:
				selectCarOne();
				break;
			case 4:
				updateCarOne();
				break;
			case 5:
				deleteCarOne();
				break;
			}
		}
	}

	private void updateCarOne() {
		System.out.println("*** 수정 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("수정하고자 하는 자동차 번호를 입력하세요.");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		sc.nextLine();
		System.out.println("1. 모델명 / 2. 가격 / 3. 출시일");
		System.out.print("수정 항목 선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();

		switch (menu) {
		case 1:
			updateModel(carNo);
			break;
		case 2:
			updatePrice(carNo);
			break;
		case 3:
			updateDate(carNo);
			break;
		}
	}

	private void updateDate(int carNo) {
		System.out.print("출시일 : ");
		Object obj = sc.nextLine();
		int result = controller.updateDate(carNo, obj);
		dmlResultPrint(result, "수정");
	}

	private void updatePrice(int carNo) {
		System.out.print("가격 : ");
		Object obj = sc.nextInt();
		int result = controller.updatePrice(carNo, obj);
		dmlResultPrint(result, "수정");
	}

	private void updateModel(int carNo) {
		System.out.print("모델명 : ");
		Object obj = sc.nextLine();
		int result = controller.updateModel(carNo, obj);
		dmlResultPrint(result, "수정");
	}

	private void deleteCarOne() {
		System.out.println("*** 삭제 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("삭제하고자 하는 자동차 번호를 입력하세요.");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		sc.nextLine();
		int result = controller.deleteCarOne(carNo);
		dmlResultPrint(result, "삭제");
	}

	private void selectCarOne() {
		System.out.println("*** 단일 조회 ***");
		System.out.println("1. 번호 / 2. 모델명 / 3. 가격 / 4. 출시일");
		System.out.print("선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();

		switch (menu) {
		case 1:
			selectNumber();
			break;
		case 2:
			selectModel();
			break;
		case 3:
			selectPrice();
			break;
		case 4:
			selectDate();
			break;
		}

	}

	private void selectDate() {
		System.out.println("출시일 기준으로 검색합니다.");
		System.out.println("0000-00-00 형식으로 입력");
		System.out.print("출시일 : ");
		String date = sc.nextLine();
		Car car = controller.selectCarOneByDate(date);
		if (car != null) {
			System.out.println(car);
		} else {
			System.out.println("조회된 결과가 없습니다.");
		}
	}

	private void selectPrice() {
		System.out.println("가격을 기준으로 검색합니다.");
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		Car car = controller.selectCarOneByPrice(price);
		if (car != null) {
			System.out.println(car);
		} else {
			System.out.println("조회된 결과가 없습니다.");
		}
	}

	private void selectModel() {
		System.out.println("모델명을 기준으로 검색합니다.");
		System.out.print("모델명 : ");
		String model = sc.nextLine();
		Car car = controller.selectCarOneByModel(model);
		if (car != null) {
			System.out.println(car);
		} else {
			System.out.println("조회된 결과가 없습니다.");
		}
	}

	private void selectNumber() {
		System.out.println("번호 기준으로 검색합니다.");
		System.out.print("번호 : ");
		int number = sc.nextInt();
		sc.nextLine();
		Car car = controller.selectCarOneByNumber(number);
		if (car != null) {
			System.out.println(car);
		} else {
			System.out.println("조회된 결과가 없습니다.");
		}
	}

	public void selectCarAll() {
		System.out.println("*** 목록 조회 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
	}

	public void printList(List<Car> list) {
		if (list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for (Car c : list) {
				System.out.println(c);
			}
		}
	}

	public void insertCarOne() {
		System.out.println("*** 추가 ***");
		System.out.println("모델명, 가격, 출시일을 입력하세요.");
		System.out.println("다만, 출시일은 반드시 0000-00-00 형식으로 입력해주세요.");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("출시일 정보를 입력하시겠습니까? (Y/N)");
		String dateFlag = sc.nextLine();
		String date = null;
		if ("Y".equals(dateFlag)) {
			System.out.print("출시일 : ");
			date = sc.nextLine();
		}
		int result = controller.insertCarOne(modelName, price, date);
		dmlResultPrint(result, "추가");
	}

	public void dmlResultPrint(int result, String menuName) {
		if (result > 0)
			System.out.println(menuName + "이(가) 정상 수행되었습니다.");
		else
			System.out.println(menuName + "중 오류가 발생하였습니다.");
	}
}
