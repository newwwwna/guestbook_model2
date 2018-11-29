package com.javalec.guestbook.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class GetGuestBookListController implements IController {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String keyword = req.getParameter("search");
		List<GuestBookVO> list = null;
		String select = req.getParameter("select");
		GuestBookDAO dao = new GuestBookDAO();

		if (keyword != null) {
			if (select.equals("name")) {
				list = dao.nameSearch(keyword);
			} else {
				list = dao.search(keyword);
			}
		} else {
			list = dao.getGuestBookList();
		}

		req.setAttribute("list", list);

	
		return "index";
	}

}
