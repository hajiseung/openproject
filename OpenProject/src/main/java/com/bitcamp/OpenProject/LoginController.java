package com.bitcamp.OpenProject;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.member.memberDao.JdbcTemplateMemberDao;
import com.bitcamp.OpenProject.member.service.MemberLoginService;

@Controller
@RequestMapping("/LoginForm")
public class LoginController {

	@Autowired
	private MemberLoginService loginService;

//	@RequestMapping("/LoginForm")
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView LoginForm(@RequestParam(value = "no", required = false) String num) {
		return new ModelAndView("LoginForm");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam(value = "userID", required = false) String userId,
			@RequestParam(value = "userPW", required = false) String password, HttpSession session)
			throws SQLException {

		// request.getSession()과 같은 객체를 받을 수 있다.
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("Loginfail");

		if (userId != null && password != null) {

			if (loginService.login(userId, password, session)) {

				modelAndView.setViewName("Index");
			}
		}
		return modelAndView;
	}
}