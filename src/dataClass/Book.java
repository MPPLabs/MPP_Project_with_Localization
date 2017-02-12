package dataClass;

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
	public int getId()
	{
		return this.id;
	}
	public void setBookName(String name)
	{
		this.bookName=name;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookDate(Timestamp date)
	{
		this.bookDate=date;
	}
	public Timestamp getBookDate()
	{
		return bookDate;
	}
	public void setBookDescription(String description)
	{
		this.bookDescription=description;
	}
	public String getBookDescription()
	{
		return bookDescription;
	}
	public void setBookTextLink(String textLink)
	{
		this.bookTextLink=textLink;
	}
	public String getBookTextLink()
	{
		return bookTextLink;
	}
	public void setAuthorId(int authorId)
	{
		this.authorId=authorId;
	}
	public int getAuthorId()
	{
		return this.authorId;
	}
}
