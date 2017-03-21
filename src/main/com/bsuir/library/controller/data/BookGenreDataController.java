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
import main.com.bsuir.library.dataClass.BookGenre;

public class BookGenreDataController {

	public void setBookGenreTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<BookGenre> bookGenreList=new ArrayList<BookGenre>();
		try{
			rs=dbConnection.getDataFromDB("lib_book_genre");
			while(rs.next())
			{
				BookGenre bookGenre = new BookGenre();
				bookGenre.setBookId(rs.getInt("lib_book_id"));
				bookGenre.setGenreId(rs.getInt("lib_book_genre_id"));
				bookGenre.setId(rs.getInt("lib_genre_id"));
				bookGenreList.add(bookGenre);
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
		request.setAttribute("bookGenreList", bookGenreList);
		
	}
}
