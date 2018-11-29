package com.javalec.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class DeleteController implements IController{

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("no");
		String password = req.getParameter("pw");

		if (password != null || no != null) {
			int id = Integer.parseInt(no);
			GuestBookDAO dao = new GuestBookDAO();
			GuestBookVO vo = new GuestBookVO();

			vo.setNo(id);
			vo.setPassword(password);

			dao.delete(vo);
		}
		
		return "getguestbooklist.do";
	
	}
}
