package com.bitcamp.OpenProject.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.OpenProject.Jdbc.JdbcUtil;
import com.bitcamp.OpenProject.member.model.Message;

public class JdbcTemplateMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public int insert(Message message) throws SQLException {
		String sql = "insert into guestbook_message (guest_name, password, message) values (?, ?, ?)";

		int result = jdbcTemplate.update(sql, message.getGuestName(), message.getPassword(), message.getMessage());

		return result;
	}

	public int selectCount() throws SQLException {
		String sql = "select count(*) from guestbook_message";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	public List<Message> selectList(int firstRow, int endRow) throws SQLException {
//		String sql = "SELECT * FROM guestbook_message m where message_id<=? and message_id>=? order by m.message_id desc";
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		List<Message> list = jdbcTemplate.query(sql, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setGuestName(rs.getString("guest_name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				return message;
			}
		}, firstRow, endRow);
		return list.isEmpty() ? null : list;
	}

	public Message select(int messageId) throws SQLException {
		String sql = "select * from guestbook_message where message_id = ?";
		List<Message> list = jdbcTemplate.query(sql, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setGuestName(rs.getString("guest_name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				return message;
			}
		}, messageId);
		return list.isEmpty() ? null : list.get(0);
	}
	

	public int delete(int messageId) throws SQLException {
		String sql = "delete from guestbook_message where message_id = ?";
		int result = jdbcTemplate.update(sql, messageId);

		return result;
	}
}
