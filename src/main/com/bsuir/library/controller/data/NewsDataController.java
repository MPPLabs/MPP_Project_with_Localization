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
import main.com.bsuir.library.dataClass.News;

public class NewsDataController {

	public void setNewsTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<News> newsList=new ArrayList<News>();
		try{
			rs=dbConnection.getDataFromDB("lib_news");
			while(rs.next())
			{
				News news = new News();
				news.setHeader(rs.getString("lib_news_header"+dbDataLanguage));
				news.setId(rs.getInt("lib_news_id"));
				news.setPublicateDate(rs.getTimestamp("lib_news_date"));
				news.setText(rs.getString("lib_news_text"+dbDataLanguage));
				newsList.add(news);
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
		request.setAttribute("newsList", newsList);
		
	}
}
