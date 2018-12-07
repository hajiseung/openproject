package com.bitcamp.OpenProject;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.bitcamp.OpenProject.member.model.MemberInfo;
import com.bitcamp.OpenProject.member.service.MemberGetListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberGetListService service;

	@RequestMapping("/MemberList")
	public ModelAndView getList(MemberInfo memberInfo, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {

			modelAndView.addObject("memberList", service.getList(memberInfo, request));
			modelAndView.setViewName("MemberList");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;

	}
}
