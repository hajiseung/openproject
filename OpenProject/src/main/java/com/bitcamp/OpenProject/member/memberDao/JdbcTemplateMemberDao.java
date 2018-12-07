package com.bitcamp.OpenProject.member.memberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bitcamp.OpenProject.Jdbc.JdbcUtil;
import com.bitcamp.OpenProject.member.model.MemberInfo;

public class JdbcTemplateMemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private MemberInfo makeMemberFromResultSet(ResultSet rs) throws SQLException {
		MemberInfo member = new MemberInfo();
		member.setUserID(rs.getString("userId"));
		member.setUserName(rs.getString("userName"));
		member.setUserPhoto(rs.getString("userPhoto"));

		return member;
	}

	public int insertMemberInfo(/* Connection conn, */MemberInfo memberInfo) throws SQLException {
		int resultCnt = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String insert_sql = "insert into webmember (userId, userPw, username, userphoto) values(?, ?, ?, ?)";
		resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(insert_sql, new String[] { "idx" });
				pstmt.setString(1, memberInfo.getUserID());
				pstmt.setString(2, memberInfo.getUserPW());
				pstmt.setString(3, memberInfo.getUserName());
				pstmt.setString(4, memberInfo.getUserPhoto());

				return pstmt;
			}
		}, keyHolder);

		Number keyValue = keyHolder.getKey();
		memberInfo.setIdx(keyValue.intValue());
		return resultCnt;
	}

	public List<MemberInfo> getList(/* Connection conn, */MemberInfo memberInfo) throws SQLException {
		String sql = "select * from Webmember";
		List<MemberInfo> list = jdbcTemplate.query(sql, new RowMapper<MemberInfo>() {
			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setUserID(rs.getString("userId"));
				memberInfo.setUserPW(rs.getString("userPW"));
				memberInfo.setUserName(rs.getString("userName"));
				memberInfo.setUserPhoto(rs.getString("userPhoto"));
				return memberInfo;
			}
		});
		return list;
	}

	public MemberInfo getMemberInfo(/* Connection conn, */String id) {

		ResultSet rs = null;

		String sql = "select * from webmember where userId = ?";
		// ResultSet타입으로 가져온다
		List<MemberInfo> memberinfo = jdbcTemplate.query(sql, new RowMapper<MemberInfo>() {
			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo memberinfo = new MemberInfo();
				memberinfo.setUserID(rs.getString("userId"));
				memberinfo.setUserPW(rs.getString("userPW"));
				memberinfo.setUserName(rs.getString("userName"));
				memberinfo.setUserPhoto(rs.getString("userPhoto"));

				return memberinfo;
			}
		}, id);

		return memberinfo.isEmpty() ? null : memberinfo.get(0);
	}

	public int ModifyMemberInfo(MemberInfo memberInfo) {
		int result;
		String sql = "update webmember set userPW=?, username=?, userPhoto=? where userId=?";
		result = jdbcTemplate.update(sql, memberInfo.getUserPW(), memberInfo.getUserName(), memberInfo.getUserPhoto(),
				memberInfo.getUserID());
		return result;

	}

	public int DeleteMemberInfo(String id) {
		int result = 0;
		String sql = "delete from webmember where userId = ?";
		result = jdbcTemplate.update(sql, id);
		return result;
	}

}
