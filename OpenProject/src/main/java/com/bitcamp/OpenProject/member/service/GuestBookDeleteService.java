package com.bitcamp.OpenProject.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.OpenProject.Dao.JdbcTemplateMessageDao;

public class GuestBookDeleteService {
	@Autowired
	private JdbcTemplateMessageDao service;

	public void deleteMessage(int messageId) throws SQLException {
		int result = service.delete(messageId);

		System.out.println(result + "개 행을 삭제하였습니다.");
	}
}
