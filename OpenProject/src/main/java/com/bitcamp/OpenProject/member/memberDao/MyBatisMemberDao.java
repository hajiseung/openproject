package com.bitcamp.OpenProject.member.memberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bitcamp.OpenProject.Jdbc.JdbcUtil;
import com.bitcamp.OpenProject.member.model.MemberInfo;

public class MyBatisMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String mapperPath = "com.bitcamp.OpenProject.mapper.mybatis.MemberMapper";

	private MemberInfo makeMemberFromResultSet(ResultSet rs) throws SQLException {
		MemberInfo member = new MemberInfo();
		member.setUserID(rs.getString("userId"));
		member.setUserName(rs.getString("userName"));
		member.setUserPhoto(rs.getString("userPhoto"));

		return member;
	}

	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		return sqlSessionTemplate.update(mapperPath + ".insertMember", memberInfo);
	}

	public MemberInfo getMemberInfo(String id) {

		MemberInfo aa = sqlSessionTemplate.selectOne(mapperPath + ".selectById", id);
		return aa;
	}

/*	public int ModifyMemberInfo(MemberInfo memberInfo) {
		int result;
		String sql = "update webmember set password=?, username=?, userPhoto=? where userId=?";
		result = sqlSessionTemplate.update(sql, memberInfo.getUserPW(), memberInfo.getUserName(),
				memberInfo.getUserPhoto(), memberInfo.getUserID());
		return result;
	}*/

	public int DeleteMemberInfo(String id) {
		int result = 0;
		String sql = "delete from webmember where userId = ?";
		result = sqlSessionTemplate.update(sql, id);
		return result;
	}

}
