package com.bitcamp.OpenProject;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.member.model.Message;
import com.bitcamp.OpenProject.member.service.GuestBookGetViewService;

@Controller
public class GuestBookViewController {

	@Autowired
	private GuestBookGetViewService service;

	@RequestMapping("/guestbook/GuestBookView/{id}")
	public ModelAndView getView(@PathVariable("id") int id) throws SQLException {
		ModelAndView modelAndView = new ModelAndView();
		Message message = service.getMessage(id);
		message.setPassword("");
		System.out.println(message);
		modelAndView.setViewName("/guestbook/GuestBookView");
		modelAndView.addObject("message", message);

		return modelAndView;

	}
}
