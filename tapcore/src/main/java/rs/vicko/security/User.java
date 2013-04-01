package rs.vicko.security;

public class User
{
	private int id;
	private String fullName;
	private String username;
	private String password;

	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String fullName, String username, String password)
	{
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}