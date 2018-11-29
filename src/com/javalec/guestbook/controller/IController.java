package com.javalec.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {

	String handleRequest(HttpServletRequest req, HttpServletResponse resp);
}
