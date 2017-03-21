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
import main.com.bsuir.library.dataClass.Book;

public class BookDataController {

	public void setBookTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<Book> bookList= new ArrayList<Book>();
		try {
			rs=dbConnection.getDataFromDB("lib_book");
			while(rs.next())
			{
				Book book = new Book();
				book.setBookName(rs.getString("lib_book_name"+dbDataLanguage));
				book.setBookDate(rs.getTimestamp("lib_book_date"));
				book.setBookDescription(rs.getString("lib_book_description"+dbDataLanguage));
				book.setBookTextLink(rs.getString("lib_book_text_link"+dbDataLanguage));
				book.setAuthorId(rs.getInt("lib_book_author_id"));
				book.setId(rs.getInt("lib_book_id"));
				bookList.add(book);
			}
			rs.close();
		} catch (Exception e) {
			throw new DataControllerException(e);
		}
		finally
		{
			dbConnection.closeGettingDataFromDB();
			dbConnection.closeDBConnection();
		}
		request.setAttribute("bookList", bookList);
		
	}
}
