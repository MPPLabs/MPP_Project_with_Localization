package dataClass;

import java.sql.Timestamp;

public class Chat {

	private int id;
	private String text;
	private Timestamp publicateDate;
	private int senderId;
	public Chat(int id,String text,Timestamp publicateDate,int senderId)
	{
		this.id=id;
		this.text=text;
		this.publicateDate=publicateDate;
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
