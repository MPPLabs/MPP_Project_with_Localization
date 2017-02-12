package dataClass;

import java.sql.Timestamp;

public class Comment {

	private int id;
	private String text;
	private Timestamp publicateDate;
	private int bookId;
	private int senderId;
	public Comment(int id,String text,Timestamp publicateDate,int bookId,int senderId)
	{
		this.id=id;
		this.text=text;
		this.publicateDate=publicateDate;
		this.bookId=bookId;
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
	public int getBookId()
	{
		return this.bookId;
	}
	public int getSenderId()
	{
		return this.senderId;
	}
}
