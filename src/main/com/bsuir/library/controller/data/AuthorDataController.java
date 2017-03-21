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
import main.com.bsuir.library.dataClass.Author;

public class AuthorDataController {

	public void setAuthorTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<Author> authorList = new ArrayList<Author>();
		try {
			rs=dbConnection.getDataFromDB("lib_author");
			while(rs.next())
			{
				Author author = new Author();
				author.setAuthorName(rs.getString("lib_author_name"+dbDataLanguage));
				author.setAuthorFemale(rs.getString("lib_author_female"+dbDataLanguage));
				author.setAuthorBiography(rs.getString("lib_author_biography"+dbDataLanguage));
				author.setId(rs.getInt("lib_author_id"));
				authorList.add(author);
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
		request.setAttribute("authorList", authorList);
	}
}
