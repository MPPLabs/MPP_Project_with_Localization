package main.com.bsuir.library.dataClass;

import java.sql.Timestamp;

public class Comment {

	private int id;
	private String text;
	private Timestamp publicateDate;
	private int bookId;
	private int senderId;
	public void setId(int id)
	{
		this.id=id;
	}
	public void setText(String text)
	{
		this.text=text;
	}
	public void setBookId(int bookId)
	{
		this.bookId=bookId;
	}
	public void setSenderId(int senderId)
	{
		this.senderId=senderId;
	}
	public void setPublicateDate(Timestamp publicateDate)
	{
		this.publicateDate=publicateDate;
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
