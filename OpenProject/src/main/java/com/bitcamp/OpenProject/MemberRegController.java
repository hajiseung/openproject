package com.bitcamp.OpenProject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.member.model.MemberInfo;
import com.bitcamp.OpenProject.member.service.MemberRegService;

@Controller
@RequestMapping("/MemberRegForm")
public class MemberRegController {

	@Autowired
	private MemberRegService regService;

	@RequestMapping(method = RequestMethod.GET)
	public String GetMemberRegForm() {
		String str = "MemberRegForm";

		return str;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView MemberReg(MemberInfo member, HttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {

		ModelAndView modelAndView = new ModelAndView();

		/*
		 * String userId = request.getParameter("userID"); System.out.println("userID: "
		 * + userId);
		 */

		try {
			int resultCnt = regService.memberReg(member, request);
			System.out.println("Controller - 신규 회원의 IDX 값 : " + member.getIdx());
			
			if (resultCnt == 0) {
				modelAndView.setViewName("regok");
			} else {
				member.setUserPW("");
				System.out.println(member);
				modelAndView.addObject("logininfo", member);
				modelAndView.setViewName("Index");
			}
		} catch (SQLException e) {
			modelAndView.setViewName("regok");
			e.printStackTrace();
		}

		return modelAndView;
	}

}
