package main.com.bsuir.library.dao;

import java.sql.*;

import javax.swing.text.html.parser.Entity;

import com.sun.scenario.effect.impl.prism.PrImage;

import main.com.bsuir.library.dao.exception.DaoException;

public abstract class AbstractDaoController implements DaoController<Entity, PrImage> {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    
	private Connection connection;
	private ResultSet rs;
	private Statement stmt;
	public void startConnectionToDB(String url,String user,String password) throws DaoException
	{
		try
		{
			this.connection = DriverManager.getConnection(url,user,password);
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	public void closeDBConnection() throws DaoException
	{
		try {
			this.connection.close();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	public ResultSet getDataFromDB(String tableName) throws SQLException
	{

		this.stmt = this.connection.createStatement();
		this.rs = stmt.executeQuery("SELECT * FROM "+tableName);
		return rs;
	}
	public void closeGettingDataFromDB() throws SQLException
	{
		this.stmt.close();
		this.rs.close();
	}
}
