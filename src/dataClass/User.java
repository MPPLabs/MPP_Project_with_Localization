package dataClass;

public class User {

	private int id;
	private String login;
	private String password;
	private String name;
	private String female;
	private int gender;
	private int age;
	private int status;
	
	public User(int id,String login,String password,String name,String female,int gender,int age,int status)
	{
		this.id=id;
		this.login=login;
		this.password=password;
		this.name=name;
		this.female=female;
		this.gender=gender;
		this.age=age;
		this.status=status;
	}
	public int getId()
	{
		return this.id;
	}
	public String getLogin()
	{
		return this.login;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getName()
	{
		return this.name;
	}
	public String getFemale()
	{
		return this.female;
	}
	public int getGender()
	{
		return this.gender;
	}
	public int getAge()
	{
		return this.age;
	}
	public int getStatus()
	{
		return this.status;
	}
}
