package com.gn.homework.controller;

import com.gn.homework.model.dao.MarketDao;
import com.gn.homework.model.vo.MarketVo;

public class MarketController {

	MarketDao md = new MarketDao();

	public MarketVo checkId(String id) {
		return md.checkId(id);
	}

	public int signup(String id, String pw, String name) {
		return md.signup(id, pw, name);
	}

	public MarketVo checkIdPw(String id, String pw) {
		return md.checkIdPw(id, pw);
	}

}
