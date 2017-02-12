package dataClass;

public class AuthorCatalog {
	private int id;
	private int authorStatus;
	private int sectionId;
	private int authorId;
	public AuthorCatalog(int id, int authorStatus,int sectionId,int authorId)
	{
		this.id=id;
		this.authorStatus=authorStatus;
		this.sectionId=sectionId;
		this.authorId=authorId;
	}
	public int getId()
	{
		return this.id;
	}
	public int getAuthorStatus()
	{
		return this.authorStatus;
	}
	public int getSectionId()
	{
		return this.sectionId;
	}
	public int getAuthorId()
	{
		return this.authorId;
	}
}
