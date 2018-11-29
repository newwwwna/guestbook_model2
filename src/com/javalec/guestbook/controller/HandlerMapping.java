package com.javalec.guestbook.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private Map<String, IController> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, IController>();
		mappings.put("/getguestbooklist.do", new GetGuestBookListController());
		mappings.put("/add.do", new AddController());
		mappings.put("/addform.do", new AddFormController());
		mappings.put("/deleteform.do", new DeleteFormController());
		mappings.put("/delete.do", new DeleteController());
		mappings.put("/update.do", new UpdateController());
		mappings.put("/updatecon.do", new UpdateconController());
		mappings.put("/updateform.do", new UpdateFormController());
	
	}
	
	public IController getController(String path) {
		return mappings.get(path);
	}
	
	
}
