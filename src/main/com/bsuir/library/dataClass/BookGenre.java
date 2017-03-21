package main.com.bsuir.library.dataClass;

public class BookGenre {
	private int id;
	private int bookId;
	private int genreId;
	public void setId(int id)
	{
		this.id=id;
	}
	public void setBookId(int bookId)
	{
		this.bookId=bookId;
	}
	public void setGenreId(int genreId)
	{
		this.genreId=genreId;
	}
	public int getId()
	{
		return this.id;
	}
	public int getBookId()
	{
		return this.bookId;
	}
	public int getGenreId()
	{
		return this.genreId;
	}
}
