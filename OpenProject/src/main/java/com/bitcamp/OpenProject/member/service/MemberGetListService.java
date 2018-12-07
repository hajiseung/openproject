package com.bitcamp.OpenProject.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.OpenProject.Jdbc.ConnectionProvider;
import com.bitcamp.OpenProject.member.memberDao.JdbcTemplateMemberDao;
import com.bitcamp.OpenProject.member.memberDao.MemberDao;
import com.bitcamp.OpenProject.member.model.MemberInfo;

public class MemberGetListService {

//	@Autowired
//	private MemberDao memberDao;

	@Autowired
	private JdbcTemplateMemberDao memberDao;

//	private Connection conn;

	public List<MemberInfo> getList(MemberInfo memberInfo, HttpServletRequest request) throws SQLException {
//		conn = ConnectionProvider.getConnection();
		List<MemberInfo> list = memberDao.getList(/* conn, */memberInfo);
		return list;
	}

	public MemberInfo getMemberInfo(String userId) {
		MemberInfo memberInfo = memberDao.getMemberInfo(userId);
		return memberInfo;
	}
}
