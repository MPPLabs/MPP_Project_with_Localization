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
import main.com.bsuir.library.dataClass.Message;

public class MessageDataController {

	public void setMessageTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<Message> messageList=new ArrayList<Message>();
		try{
			rs=dbConnection.getDataFromDB("lib_message");
			while(rs.next())
			{
				Message message = new Message();
				message.setId(rs.getInt("lib_message_id"));
				message.setPublicateDate(rs.getTimestamp("lib_message_date"));
				message.setRecipientId(rs.getInt("lib_user_recipient_id"));
				message.setRecippientStatus(rs.getInt("lib_message_recipient_status"));
				message.setSenderId(rs.getInt("lib_user_sender_id"));
				message.setText(rs.getString("lib_message_text"));
				message.setSenderStatus(rs.getInt("lib_message_sender_status"));
				messageList.add(message);
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
		request.setAttribute("messageList", messageList);
		
	}
}
