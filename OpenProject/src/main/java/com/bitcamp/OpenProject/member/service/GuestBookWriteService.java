package com.bitcamp.OpenProject.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.OpenProject.Dao.JdbcTemplateMessageDao;
import com.bitcamp.OpenProject.Dao.MessageDao;
import com.bitcamp.OpenProject.Jdbc.ConnectionProvider;
import com.bitcamp.OpenProject.Jdbc.JdbcUtil;
import com.bitcamp.OpenProject.member.model.Message;

public class GuestBookWriteService {

//	@Autowired
//	MessageDao messageDao;

	@Autowired
	JdbcTemplateMessageDao messageDao;

	public void write(Message message) throws ServiceException {
		try {
			messageDao.insert(message);

		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);

		}
	}
}
