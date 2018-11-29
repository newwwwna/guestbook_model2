package com.javalec.guestbook.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateconController implements IController {
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {

		if (req.getParameter("pw").equals(req.getParameter("password"))) {
			return "updateform";
		} else {
			return "getguestbooklist.do";
		}

	}
}
