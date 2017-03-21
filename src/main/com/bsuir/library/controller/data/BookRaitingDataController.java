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
import main.com.bsuir.library.dataClass.BookRaiting;

public class BookRaitingDataController {

	public void setBookRaitingTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<BookRaiting> bookRaitingList=new ArrayList<BookRaiting>();
		try{
			rs=dbConnection.getDataFromDB("lib_book_rating");
			while(rs.next())
			{
				BookRaiting bookRaiting = new BookRaiting();
				bookRaiting.setBookId(rs.getInt("lib_book_id"));
				bookRaiting.setId(rs.getInt("lib_book_rating_id"));
				bookRaiting.setRaitingCount(rs.getInt("lib_book_rating_count"));
				bookRaiting.setUserId(rs.getInt("lib_user_id"));
				bookRaitingList.add(bookRaiting);
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
		request.setAttribute("bookRaitingList", bookRaitingList);
		
	}
}
