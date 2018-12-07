package com.bitcamp.OpenProject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.OpenProject.member.model.Message;
import com.bitcamp.OpenProject.member.service.GuestBookWriteService;
import com.bitcamp.OpenProject.member.service.ServiceException;

@Controller
@RequestMapping("/guestbook/GuestBookWrite")
public class GuestBookWriteController {

	@Autowired
	private GuestBookWriteService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getBookWrite() {

		return "guestbook/GuestBookWrite";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postBookWrite(Message message) throws ServiceException {
		service.write(message);
		return "redirect:/guestbook/GuestBookList";

	}
}
