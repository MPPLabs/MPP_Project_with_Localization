package main.com.bsuir.library.controller.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import main.com.bsuir.library.controller.DataController;
import main.com.bsuir.library.controller.exception.DataControllerException;
import main.com.bsuir.library.dao.exception.DaoException;
import main.com.bsuir.library.dataClass.Chat;

public class ChatDataController {

	public void setChatTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<Chat> chatList=new ArrayList<Chat>();
		try{
			rs=dbConnection.getDataFromDB("lib_chat");
			while(rs.next())
			{
				Chat chat = new Chat();
				chat.setId(rs.getInt("lib_chat_id"));
				chat.setPublicateDate(rs.getTimestamp("lib_chat_message_date"));
				chat.setSenderId(rs.getInt("lib_chat_message_sender_id"));
				chat.setText(rs.getString("lib_chat_message_text"+dbDataLanguage));
				chatList.add(chat);
			}
			rs.close();
		}catch(Exception e)
		{
			throw new DataControllerException(e);
		}
		finally
		{
			dbConnection.closeGettingDataFromDB();
			dbConnection.closeDBConnection();
		}
		request.setAttribute("chatList", chatList);
		
	}
}
