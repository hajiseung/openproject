package com.bitcamp.OpenProject.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.OpenProject.member.memberDao.JdbcTemplateMemberDao;
import com.bitcamp.OpenProject.member.model.MemberInfo;

public class MemberModifyService {

	@Autowired
	private JdbcTemplateMemberDao memberDao;

	public int ModifyMemberInfo(MemberInfo memberInfo, HttpServletRequest request)
			throws IllegalStateException, IOException, SQLException {

//		System.out.println("memberInfo = " + memberInfo);

		int resultCnt = 0;

		// DB 저장용 파일 이름, 물리적 저장할 때의 이름
		String imgName = "";

		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";

		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		if (!memberInfo.getPhotoFile().isEmpty()) {
			imgName = memberInfo.getUserID() + "_" + memberInfo.getPhotoFile().getOriginalFilename();

			// 물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));
			// DB에 저장할 이름 SET
			memberInfo.setUserPhoto(imgName);
			System.out.println(dir);
		}
		resultCnt = memberDao.ModifyMemberInfo(memberInfo);
//		System.out.println("Service - 신규 회원의 IDX 값 : " + memberInfo.getIdx());
		return resultCnt;

	}
}
