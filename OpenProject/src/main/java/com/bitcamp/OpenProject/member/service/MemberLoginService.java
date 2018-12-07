package com.bitcamp.OpenProject.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.OpenProject.Jdbc.ConnectionProvider;
import com.bitcamp.OpenProject.member.memberDao.JdbcTemplateMemberDao;
import com.bitcamp.OpenProject.member.memberDao.MemberDao;
import com.bitcamp.OpenProject.member.memberDao.MemberDaoInterface;
import com.bitcamp.OpenProject.member.memberDao.MyBatisMemberDao;
import com.bitcamp.OpenProject.member.model.MemberInfo;

public class MemberLoginService {

//	@Autowired
//	private MemberDao memberDao;

//	@Autowired
//	private JdbcTemplateMemberDao memberDao;

//	@Autowired
//	private MyBatisMemberDao memberDao;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
//	인터페이스라  주입(Autowired)은 되지 않는다.
	private MemberDaoInterface memberDao;

	public boolean login(String id, String password, HttpSession session) throws SQLException {
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
//		Connection conn = ConnectionProvider.getConnection();

		boolean result = false;
//		MemberInfo memberinfo = memberDao.getMemberInfo(conn, id);
		MemberInfo memberinfo = memberDao.getMemberInfo(id);

		// 사용자가 입력한 id의 데이터 존재 유무 확인
		if (memberinfo.getUserID() != null && memberinfo.getUserPW().equals(password)) {
			// 비밀 번호 비교
			// 로그인 처리 : 세션에 사용자 데이터 저장
			memberinfo.setUserPW("");
			session.setAttribute("logininfo", memberinfo);
			result = true;
		}
		return result;
	}

}
