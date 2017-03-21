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
import main.com.bsuir.library.dataClass.AuthorCatalog;

public class AuthorCatalogDataController {

	public void setAuthorCatalogTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<AuthorCatalog> authorCatalogList=new ArrayList<AuthorCatalog>();
		try{
			rs=dbConnection.getDataFromDB("lib_author_catalog");
			while(rs.next())
			{
				AuthorCatalog authorCatalog = new AuthorCatalog();
				authorCatalog.setAuthorId(rs.getInt("lib_author_id"));
				authorCatalog.setAuthorStatus(rs.getInt("lib_author_catalog_status"));
				authorCatalog.setId(rs.getInt("lib_author_catalog_id"));
				authorCatalog.setSectionId(rs.getInt("lib_section_id"));
				authorCatalogList.add(authorCatalog);
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
		request.setAttribute("authorCatalogList", authorCatalogList);
		
	}
}
