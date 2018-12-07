package com.bitcamp.OpenProject.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.OpenProject.Dao.JdbcTemplateMessageDao;
import com.bitcamp.OpenProject.member.model.Message;

public class GuestBookGetViewService {

	@Autowired
	private JdbcTemplateMessageDao messageDao;

	public Message getMessage(int id) throws SQLException {
		return messageDao.select(id);
	}
}
