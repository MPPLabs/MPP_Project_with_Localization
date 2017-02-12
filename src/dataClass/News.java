package dataClass;

import java.sql.Timestamp;

public class News {

	private int id;
	private String header;
	private String text;
	private Timestamp publicateDate;
	public News(int id,String header,String text,Timestamp publicateDate)
	{
		this.id=id;
		this.header=header;
		this.text=text;
		this.publicateDate=publicateDate;
	}
	public int getId()
	{
		return this.id;
	}
	public String getHeader()
	{
		return this.header;
	}
	public String getText()
	{
		return this.text;
	}
	public Timestamp getPublicateDate()
	{
		return this.publicateDate;
	}
}
