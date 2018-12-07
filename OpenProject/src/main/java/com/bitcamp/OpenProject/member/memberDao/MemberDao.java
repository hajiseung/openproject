package com.bitcamp.OpenProject.member.memberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bitcamp.OpenProject.Jdbc.JdbcUtil;
import com.bitcamp.OpenProject.member.model.MemberInfo;

public class MemberDao {

	private MemberInfo makeMemberFromResultSet(ResultSet rs) throws SQLException {
		MemberInfo member = new MemberInfo();
		member.setUserID(rs.getString("userId"));
		member.setUserName(rs.getString("userName"));
		member.setUserPhoto(rs.getString("userPhoto"));

		return member;
	}

	public int insertMemberInfo(Connection conn, MemberInfo memberInfo) throws SQLException {
		PreparedStatement pstmt = null;
		int resultCnt;
		String insert_sql = "insert into webmember (userId, userPw, username, userphoto) values(?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, memberInfo.getUserID());
			pstmt.setString(2, memberInfo.getUserPW());
			pstmt.setString(3, memberInfo.getUserName());
			pstmt.setString(4, memberInfo.getUserPhoto());

			resultCnt = pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}

	public List<MemberInfo> getList(Connection conn, MemberInfo memberInfo) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberInfo> list = new ArrayList<MemberInfo>();

		try {
			String sql = "select * from Webmember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				do {
					list.add(makeMemberFromResultSet(rs));
				} while (rs.next());
				return list;
			} else
				return new ArrayList<MemberInfo>();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public MemberInfo getMemberInfo(Connection conn, String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberInfo memberinfo = null;
		String sql = "select * from webmember where userId = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberinfo = new MemberInfo();
				memberinfo.setUserID(rs.getString("userId"));
				memberinfo.setUserPW(rs.getString("userPw"));
				memberinfo.setUserName(rs.getString("userName"));
				memberinfo.setUserPhoto(rs.getString("userPhoto"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return memberinfo;
	}

}
