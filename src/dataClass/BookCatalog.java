package dataClass;

public class BookCatalog {
	private int id;
	private int bookStatus;
	private int sectionId;
	private int bookId;
	public BookCatalog(int id, int bookStatus,int sectionId,int bookId)
	{
		this.id=id;
		this.bookStatus=bookStatus;
		this.sectionId=sectionId;
		this.bookId=bookId;
	}
	public int getId()
	{
		return this.id;
	}
	public int getBookStatus()
	{
		return this.bookStatus;
	}
	public int getSectionId()
	{
		return this.sectionId;
	}
	public int getBookId()
	{
		return this.bookId;
	}
}
