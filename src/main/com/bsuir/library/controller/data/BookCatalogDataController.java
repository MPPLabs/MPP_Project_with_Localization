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
import main.com.bsuir.library.dataClass.BookCatalog;

public class BookCatalogDataController {

	public void setBookCatalogTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<BookCatalog> bookCatalogList=new ArrayList<BookCatalog>();
		try{
			rs=dbConnection.getDataFromDB("lib_book_catalog");
			while(rs.next())
			{
				BookCatalog bookCatalog = new BookCatalog();
				bookCatalog.setBookId(rs.getInt("lib_book_id"));
				bookCatalog.setBookStatus(rs.getInt("lib_book_catalog_status"));
				bookCatalog.setId(rs.getInt("lib_book_catalog_id"));
				bookCatalog.setSectionId(rs.getInt("lib_section_id"));
				bookCatalogList.add(bookCatalog);
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
		request.setAttribute("bookCatalogList", bookCatalogList);
		
	}
}
