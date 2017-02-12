package dataClass;

import java.sql.Timestamp;

public class NewsComment {
	private int id;
	private String text;
	private Timestamp publicateDate;
	private int newsId;
	private int userId;
	public NewsComment(int id,String text,Timestamp publicateDate,int newsId,int userId)
	{
		this.id=id;
		this.text=text;
		this.publicateDate=publicateDate;
		this.newsId=newsId;
		this.userId=userId;
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
	public int getNewsId()
	{
		return this.newsId;
	}
	public int getUserId()
	{
		return this.userId;
	}
}
