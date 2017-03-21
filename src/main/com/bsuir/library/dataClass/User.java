package main.com.bsuir.library.dataClass;

public class User {

	private int id;
	private String login;
	private String password;
	private String name;
	private String female;
	private int gender;
	private int age;
	private int status;
	public void setId(int id)
	{
		this.id=id;
	}
	public void setLogin(String login)
	{
		this.login=login;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setFemale(String female)
	{
		this.female=female;
	}
	public void setGender(int gender)
	{
		this.gender=gender;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public void setStatus(int status)
	{
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
