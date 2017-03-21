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
import main.com.bsuir.library.dataClass.NewsComment;

public class NewsCommentDataController {

	public void setNewsCommentTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<NewsComment> newsCommentList=new ArrayList<NewsComment>();
		try{
			rs=dbConnection.getDataFromDB("lib_news_comment");
			while(rs.next())	
			{
				NewsComment newsComment = new NewsComment();
				newsComment.setId(rs.getInt("lib_news_comment_id"));
				newsComment.setNewsId(rs.getInt("lib_news_id"));
				newsComment.setPublicateDate(rs.getTimestamp("lib_news_comment_date"));
				newsComment.setText(rs.getString("lib_news_comment_text"+dbDataLanguage));
				newsComment.setUserId(rs.getInt("lib_user_id"));
				newsCommentList.add(newsComment);
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
		request.setAttribute("newsCommentList", newsCommentList);
		
	}
}
