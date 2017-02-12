package dataClass;

public class BookRaiting {
	private int id;
	private int raitingCount;
	private int bookId;
	private int userId;
	public BookRaiting(int id,int raitingCount,int bookId,int userId)
	{
		this.id=id;
		this.raitingCount=raitingCount;
		this.bookId=bookId;
		this.userId=userId;
	}
	public int getId()
	{
		return this.id;
	}
	public int getRaitingCount()
	{
		return this.raitingCount;
	}
	public int getBookId()
	{
		return this.bookId;
	}
	public int getUserId()
	{
		return this.userId;
	}

}
