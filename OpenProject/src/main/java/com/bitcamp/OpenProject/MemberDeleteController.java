package com.bitcamp.OpenProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {
	@Autowired
	private MemberDeleteService service;

	@RequestMapping("/MemberDelete")
	public ModelAndView deleteMember(@RequestParam("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		int result = service.deleteMember(id);
		if (result > 0) {
			modelAndView.setViewName("redirect:/MemberList");
		}
		return modelAndView;

	}
}
