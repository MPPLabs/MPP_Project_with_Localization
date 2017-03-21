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
import main.com.bsuir.library.dataClass.Section;

public class SectionDataController {

	public void setSectionTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<Section> sectionList=new ArrayList<Section>();
		try{
			rs=dbConnection.getDataFromDB("lib_section");
			while(rs.next())
			{
				Section section = new Section();
				section.setDescription(rs.getString("lib_section_description"+dbDataLanguage));
				section.setHeader(rs.getString("lib_section_header"+dbDataLanguage));
				section.setId(rs.getInt("lib_section_id"));
				section.setName(rs.getString("lib_section_name"+dbDataLanguage));
				section.setNumber(rs.getInt("lib_section_number"));
				sectionList.add(section);
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
		request.setAttribute("sectionList", sectionList);
		
	}
}
