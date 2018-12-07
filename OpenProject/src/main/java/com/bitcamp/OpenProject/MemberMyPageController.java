package com.bitcamp.OpenProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMyPageController {

	@RequestMapping("/mypage")
	public String getMyPage() {

		return "mypage";
	}
}
