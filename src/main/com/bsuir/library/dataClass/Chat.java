package main.com.bsuir.library.dataClass;

import java.sql.Timestamp;

public class Chat {

	private int id;
	private String text;
	private Timestamp publicateDate;
	private int senderId;
	public void setId(int id)
	{
		this.id=id;
	}
	public void setText(String text)
	{
		this.text=text;
	}
	public void setPublicateDate(Timestamp publicateDate)
	{
		this.publicateDate=publicateDate;
	}
	public void setSenderId(int senderId)
	{
		this.senderId=senderId;
	}
	public int getId()
	{
		return this.id;
	}
	public String getText()
	{
		return this.text;
	}
	public Timestamp getPublicateDate()
	{
		return this.publicateDate;
	}
	public int getSenderId()
	{
		return this.senderId;
	}
}
