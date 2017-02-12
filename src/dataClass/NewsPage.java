package dataClass;

public class NewsPage {

	private int id;
	private int newsStatus;
	private int newsId;
	private int sectionId;
	public NewsPage(int id,int newsStatus,int newsId,int sectionId)
	{
		this.id=id;
		this.newsStatus=newsStatus;
		this.newsId=newsId;
		this.sectionId=sectionId;
	}
	public int getId()
	{
		return this.id;
	}
	public int getNewsStatus()
	{
		return this.newsStatus;
	}
	public int getNewsId()
	{
		return this.newsId;
	}
	public int getSectionId()
	{
		return this.sectionId;
	}
}
