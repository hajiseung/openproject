package com.bitcamp.OpenProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Index() {
		String str = "Index";

		return str;
	}

	/*
	 * @RequestMapping("/LoginForm") public String LoginForm() { String str =
	 * "LoginForm";
	 * 
	 * return str; }
	 */
	/*@RequestMapping("/MemberRegForm")
	public String MemberRegForm() {
		String str = "MemberRegForm";

		return str;
	}*/
}
