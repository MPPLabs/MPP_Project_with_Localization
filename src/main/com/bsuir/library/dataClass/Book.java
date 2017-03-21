package main.com.bsuir.library.dataClass;

import java.sql.Timestamp;

public class Book {
	private int id;
	private String bookName;
	private Timestamp bookDate;
	private String bookDescription;
	private String bookTextLink;
	private int authorId;

	public void setId(int id)
	{
		this.id=id;
	}
	public void setBookName(String name)
	{
		this.bookName=name;
	}
	public void setBookDate(Timestamp date)
	{
		this.bookDate=date;
	}
	public void setBookDescription(String description)
	{
		this.bookDescription=description;
	}
	public void setBookTextLink(String textLink)
	{
		this.bookTextLink=textLink;
	}
	public void setAuthorId(int authorId)
	{
		this.authorId=authorId;
	}
	public int getId()
	{
		return this.id;
	}
	public String getBookName()
	{
		return bookName;
	}
	public Timestamp getBookDate()
	{
		return bookDate;
	}
	public String getBookDescription()
	{
		return bookDescription;
	}
	public String getBookTextLink()
	{
		return bookTextLink;
	}
	public int getAuthorId()
	{
		return this.authorId;
	}
}
