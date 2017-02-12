package dataClass;

public class BookGenre {
	private int id;
	private int bookId;
	private int genreId;
	public BookGenre(int id,int bookId,int genreId)
	{
		this.id=id;
		this.bookId=bookId;
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
