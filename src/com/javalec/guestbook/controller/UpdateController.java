package com.javalec.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class UpdateController implements IController{
@Override
public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {

	GuestBookDAO dao = new GuestBookDAO();
	GuestBookVO vo = new GuestBookVO();
	
	String name = req.getParameter("name");
	String pw = req.getParameter("pw");
	String content = req.getParameter("content");
	String num = req.getParameter("no");
	int no = Integer.parseInt(num);
	
	vo.setName(name);
	vo.setPassword(pw);
	vo.setContent(content);
	vo.setNo(no);
	
	int result = dao.update(vo);
	System.out.println(result);
	
	return "getguestbooklist.do";
}
}
