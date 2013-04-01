package rs.vicko.security;

import org.springframework.context.ApplicationContext;

import rs.vicko.common.SpringHelper;

public class UsersImpl implements Users
{
	private UsersDb usersDb;

	public UsersImpl()
	{
		ApplicationContext ctx = SpringHelper.getApplicationContext();
		usersDb = (UsersDb) ctx.getBean("usersDb");
	}

	public User getUser(int id)
	{
		return usersDb.getUser(id);
	}

	public User getUser(String username)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
