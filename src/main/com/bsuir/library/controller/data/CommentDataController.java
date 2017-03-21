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
import main.com.bsuir.library.dataClass.Comment;

public class CommentDataController {

	public void setCommentTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<Comment> commentList=new ArrayList<Comment>();
		try{
			rs=dbConnection.getDataFromDB("lib_comment");
			while(rs.next())
			{
				Comment comment = new Comment();
				comment.setBookId(rs.getInt("lib_book_id"));
				comment.setId(rs.getInt("lib_comment_id"));
				comment.setSenderId(rs.getInt("lib_sender_id"));
				comment.setText(rs.getString("lib_comment_text"+dbDataLanguage));
				comment.setPublicateDate(rs.getTimestamp("lib_comment_date"));
				commentList.add(comment);
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
		request.setAttribute("commentList", commentList);
		
	}
}
