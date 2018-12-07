package com.bitcamp.OpenProject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.member.model.MemberInfo;
import com.bitcamp.OpenProject.member.service.MemberGetListService;
import com.bitcamp.OpenProject.member.service.MemberModifyService;

@Controller
//@RequestMapping("/MemberModify")
public class MemberModifyController {

	@Autowired
	private MemberModifyService service;
	@Autowired
	private MemberGetListService memGetService;

	@RequestMapping(value = "/MemberModify/{id}", method = RequestMethod.GET)
	public ModelAndView getModify(@PathVariable("id") String userId) throws SQLException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("MemberModify");

		MemberInfo memberinfo = memGetService.getMemberInfo(userId);
		modelAndView.addObject("memberInfo", memberinfo);

		return modelAndView;
	}

	@RequestMapping(value = "/MemberModify/{id}", method = RequestMethod.POST)
	public ModelAndView postModify(MemberInfo member, HttpServletRequest request)
			throws IllegalStateException, IOException {
		ModelAndView modelAndView = new ModelAndView();

		try {
			int resultCnt = service.ModifyMemberInfo(member, request);
//			System.out.println("Controller - 신규 회원의 IDX 값 : " + member.getIdx());

			if (resultCnt == 0) {
				modelAndView.setViewName("regok");
			} else {
				member.setUserPW("");
				modelAndView.addObject("memberlist", member);
				modelAndView.setViewName("redirect:/MemberList");
			}
		} catch (SQLException e) {
			modelAndView.setViewName("regok");
			e.printStackTrace();
		}
		return modelAndView;

	}
}
