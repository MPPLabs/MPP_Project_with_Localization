package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private Connection connection;
	private ResultSet rs;
	private Statement stmt;
	public void startConnectionToDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Driver found" );
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			System.out.println("Class not found"+ e);
		}
		String url="jdbc.mysql://localhost/library";
		String user = "root";
		String password = "";
		Connection connection = null;
		try
		{
			//con = DriverManager.getConnection(url,user,password);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			System.out.println("Connection successfull");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		this.connection=connection;
	}
	public Connection getDBConnection()
	{
		return this.connection;
	}
	public void closeDBConnection()
	{
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
