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
import main.com.bsuir.library.dataClass.NewsPage;

public class NewsPageDataController {

	public void setNewsPageTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<NewsPage> newsPageList=new ArrayList<NewsPage>();
		try{
			rs=dbConnection.getDataFromDB("lib_news_page");
			while(rs.next())
			{
				NewsPage newsPage = new NewsPage();
				newsPage.setId(rs.getInt("lib_news_page_id"));
				newsPage.setNewsId(rs.getInt("lib_news_id"));
				newsPage.setNewsStatus(rs.getInt("lib_news_page_status"));
				newsPage.setSectionId(rs.getInt("lib_section_id"));
				newsPageList.add(newsPage);
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
		request.setAttribute("newsPageList", newsPageList);
		
	}
}
