package com.javalec.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class SelectOneController implements IController {
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {

		GuestBookDAO dao = new GuestBookDAO();
		GuestBookVO vo = new GuestBookVO();
		GuestBookVO vo2 = new GuestBookVO();

		String num = req.getParameter("no");
		if (num != null) {
			int no = Integer.parseInt(num);
			vo.setNo(no);
			vo2 = dao.getGuestBook(vo);
			req.setAttribute("selectone", vo2);
			return "selectone";
		} else {
			return "getguestbooklist.do";
		}
	}
}
