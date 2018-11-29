package com.javalec.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class AddController implements IController{
@Override
public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
	GuestBookDAO dao = new GuestBookDAO();
	GuestBookVO vo = new GuestBookVO();
	
	String name = (String) req.getParameter("name");
	String password = (String) req.getParameter("pw");
	String content = (String) req.getParameter("content");
	
	vo.setName(name);
	vo.setPassword(password);
	vo.setContent(content);
	
	int result = dao.insert(vo);

	
	return "getguestbooklist.do";
}
}
