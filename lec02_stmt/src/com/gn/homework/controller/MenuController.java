package com.gn.homework.controller;

import com.gn.homework.model.dao.MenuDao;

public class MenuController {
	MenuDao md = new MenuDao();

	public int checkId(String id) {
		return md.checkId(id);
	}

}
