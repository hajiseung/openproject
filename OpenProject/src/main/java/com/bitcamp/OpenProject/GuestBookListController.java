package com.bitcamp.OpenProject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.member.model.MessageListView;
import com.bitcamp.OpenProject.member.service.GuestBookListService;
import com.bitcamp.OpenProject.member.service.ServiceException;

@Controller
public class GuestBookListController {

	@Autowired
	private GuestBookListService service;

	@RequestMapping("/guestbook/GuestBookList")
	public ModelAndView goGuestBookList(HttpServletRequest request) throws ServiceException {

		String pageNumberStr = request.getParameter("page");
		System.out.println("pageNumberStr=" + pageNumberStr);
		int pageNumber = 1;

		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		MessageListView viewData = service.getlist(pageNumber);

		ModelAndView modelAndView = new ModelAndView();
		// viewName
		modelAndView.setViewName("guestbook/GuestBookList");

		// view에 결과 데이터를 전달(공유)
		modelAndView.addObject("viewData", viewData);

		return modelAndView;
	}
}
