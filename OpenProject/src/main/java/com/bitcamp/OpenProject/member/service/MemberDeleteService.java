package com.bitcamp.OpenProject.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.OpenProject.member.memberDao.JdbcTemplateMemberDao;

public class MemberDeleteService {
	@Autowired
	private JdbcTemplateMemberDao memberDao;

	public int deleteMember(String id) {
		int result = 0;
		result = memberDao.DeleteMemberInfo(id);
		return result;
	}
}
