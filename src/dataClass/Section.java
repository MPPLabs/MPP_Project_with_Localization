package dataClass;

public class Section {

	private int id;
	private String name;
	private String header;
	private String description;
	private int number;
	
	public Section(int id,String name,String header, String description,int number)
	{
		this.id=id;
		this.name=name;
		this.header=header;
		this.description=description;
		this.number=number;
	}
	public int getId()
	{
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
	public String getDescription()
	{
		return this.description;
	}
	public int getNumber()
	{
		return this.number;
	}
	public String getHeader()
	{
		return this.header;
	}
}
