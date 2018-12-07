package com.bitcamp.OpenProject;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/Logout")
	public String logout(HttpSession session) {

		// 세션의 종료
		session.invalidate();

		return "redirect:/";
	}
}
