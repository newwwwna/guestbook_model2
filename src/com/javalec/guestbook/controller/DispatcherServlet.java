package com.javalec.guestbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.guestbook.util.WebUtil;

public class DispatcherServlet extends HttpServlet {

	private HandlerMapping handlerMapping ;
	private ViewResolver viewResolver;
		
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. URL에서 요청 구분하기
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. HandleRequest 에서 controller 요청
		IController ctrl = handlerMapping.getController(path);
		
		// 3. Controller의 작업 수행
		String viewName = ctrl.handleRequest(req, resp);
		
		//4. ViewResolver를 통해 View(*.jsp)를 구함
		String view = null;
		
		if(!viewName.contains(".do")) {
			//~.jsp
			view = viewResolver.getView(viewName);
			WebUtil.forward(req, resp, view);
		} else {
			// *.do 요청을 받을 경우
			view = viewName ;
			resp.sendRedirect(view);
			
		}
	}

}
