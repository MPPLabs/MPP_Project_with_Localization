package main.com.bsuir.library.controller.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;

import com.sun.scenario.effect.impl.prism.PrImage;

import main.com.bsuir.library.controller.DataController;
import main.com.bsuir.library.controller.exception.DataControllerException;
import main.com.bsuir.library.dao.AbstractDaoController;
import main.com.bsuir.library.dao.exception.DaoException;
import main.com.bsuir.library.dataClass.User;

public class UserDataController {

	public void setUserTableContent(HttpServletRequest request,String dbDataLanguage) throws DataControllerException, DaoException, SQLException
	{
		DataController dbConnection = new DataController();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
		dbConnection.startConnectionToDB(resourceBundle.getString("url"),resourceBundle.getString("login"),resourceBundle.getString("password"));
		ResultSet rs;
		List<User> userList=new ArrayList<User>();
		try{
			rs=dbConnection.getDataFromDB("lib_user");
			while(rs.next())
			{
				User user = new User();
				user.setAge(rs.getInt("lib_user_age"));
				user.setFemale(rs.getString("lib_user_female"));
				user.setGender(rs.getInt("lib_user_gender"));
				user.setId(rs.getInt("lib_user_id"));
				user.setLogin(rs.getString("lib_user_login"));
				user.setName(rs.getString("lib_user_name"));
				user.setPassword(rs.getString("lib_user_password"));
				user.setStatus(rs.getInt("lib_user_status"));
				userList.add(user);
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
		request.setAttribute("userList", userList);
		
	}

	@Override
	public Entity getByPrimaryKey(PrImage key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity update(Entity entity) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(PrImage key) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Entity entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}
}
