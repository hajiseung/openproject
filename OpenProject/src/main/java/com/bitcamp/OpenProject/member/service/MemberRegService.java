package com.bitcamp.OpenProject.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.OpenProject.Jdbc.ConnectionProvider;
import com.bitcamp.OpenProject.Jdbc.JdbcUtil;
import com.bitcamp.OpenProject.member.memberDao.JdbcTemplateMemberDao;
import com.bitcamp.OpenProject.member.memberDao.MemberDao;
import com.bitcamp.OpenProject.member.memberDao.MemberDaoInterface;
import com.bitcamp.OpenProject.member.memberDao.MyBatisMemberDao;
import com.bitcamp.OpenProject.member.model.MemberInfo;
import com.mysql.jdbc.SequentialBalanceStrategy;

public class MemberRegService {
//	@Autowired
//	private MemberDao memberDao;

//	@Autowired
//	private JdbcTemplateMemberDao memberDao;

//	@Autowired
//	private MyBatisMemberDao memberDao;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
//	인터페이스라 따로 주입은 되지 않는다.
	private MemberDaoInterface memberDao;

//	private Connection conn;

	@Transactional
	public int memberReg(MemberInfo memberInfo, HttpServletRequest request)
			throws SQLException, IllegalStateException, IOException {

		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);

		System.out.println("memberInfo = " + memberInfo);

//		conn = ConnectionProvider.getConnection();

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

//		try {
//			conn.setAutoCommit(false);

//			resultCnt = memberDao.insertMemberInfo(conn, memberInfo);
		resultCnt = memberDao.insertMemberInfo(memberInfo);

		System.out.println("Service - 신규 회원의 IDX 값 : " + memberInfo.getIdx());

//			conn.commit();

//		} catch (Exception e) {

//			JdbcUtil.rollback(conn);

//			throw e;

//		} finally {

//			conn.setAutoCommit(true);

//			JdbcUtil.close(conn);
//		}

		return resultCnt;

	}
}
