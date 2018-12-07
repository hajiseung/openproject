package com.bitcamp.OpenProject;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.member.service.GuestBookDeleteService;

@Controller
public class GuestBookDeleteController {

	@Autowired
	private GuestBookDeleteService service;

	@RequestMapping("/guestbook/GuestBookDelete")
	public String deleteMessage(@RequestParam("id") int messageId) throws SQLException {
		ModelAndView modelAndView = new ModelAndView();
		service.deleteMessage(messageId);

		return "redirect:/guestbook/GuestBookList";
	}
}
