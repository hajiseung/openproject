package com.bitcamp.OpenProject.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.OpenProject.Dao.JdbcTemplateMessageDao;
import com.bitcamp.OpenProject.Dao.MessageDao;
import com.bitcamp.OpenProject.Jdbc.ConnectionProvider;
import com.bitcamp.OpenProject.Jdbc.JdbcUtil;
import com.bitcamp.OpenProject.member.model.Message;
import com.bitcamp.OpenProject.member.model.MessageListView;

public class GuestBookListService {

//	@Autowired
//	MessageDao messageDao;

	@Autowired
	private JdbcTemplateMessageDao messageDao;

	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MessageListView getlist(int pageNumber) throws ServiceException {
//		Connection conn = null;
		int currentPageNumber = pageNumber;

		try {
//			conn = ConnectionProvider.getConnection();

			// 전체 메시지 구하기
			int messageTotalCount = messageDao.selectCount();
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;

			if (messageTotalCount > 0) {
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(firstRow, endRow);

			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();
			}

			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
					firstRow, endRow);

		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);

		} /*
			 * finally { JdbcUtil.close(conn); }
			 */
	}
}
