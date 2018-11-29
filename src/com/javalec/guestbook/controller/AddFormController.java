package com.javalec.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class AddFormController implements IController {
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		return "addform";

	}
}
