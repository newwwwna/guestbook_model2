package com.javalec.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormController implements IController{

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		return "updateform";
	}
}
