package com.gn.homework.model.vo;

import java.time.LocalDateTime;

public class MarketVo {
	private int user_no; // 사용자 번호
	private String user_id; // 사용자 아이디
	private String user_pw; // 사용자 비밀번호
	private String user_name; // 사용자 닉네임
	private LocalDateTime reg_date; // 회원가입일
	private LocalDateTime mod_date; // 정보수정일
	private int product_no; // 제품 번호
	private String product_name; // 제품명
	private int product_price; // 제품 가격
	private int product_stock; // 재고
	private int buy_no; // 거래 번호
	private int sales; // 판매수

	public MarketVo() {
		super();
	}

	public MarketVo(int user_no, String user_id, String user_pw, String user_name, LocalDateTime reg_date,
			LocalDateTime mod_date, int product_no, String product_name, int product_price, int product_stock,
			int buy_no, int sales) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.buy_no = buy_no;
		this.sales = sales;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public LocalDateTime getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDateTime reg_date) {
		this.reg_date = reg_date;
	}

	public LocalDateTime getMod_date() {
		return mod_date;
	}

	public void setMod_date(LocalDateTime mod_date) {
		this.mod_date = mod_date;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	public int getBuy_no() {
		return buy_no;
	}

	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "사용자 번호:" + user_no + ", 사용자 아이디:" + user_id + ", 사용자 비밀번호:" + user_pw + ", 사용자 닉네임:" + user_name
				+ ", 가입일:" + reg_date + ", 수정일:" + mod_date + ", 제품번호:" + product_no + ", 제품명:" + product_name + ", 가격:"
				+ product_price + ", 재고:" + product_stock + ", 거래번호:" + buy_no + ", 판매수:" + sales;
	}

}
