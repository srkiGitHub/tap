package rs.vicko.security;

import org.springframework.context.ApplicationContext;

import rs.vicko.common.ApplicationException;
import rs.vicko.common.HashHelper;
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

	public String generatePasswordHash(String password)
	{
		
		return HashHelper.calculateHash(password);
	}

	public void login(User user, String password)
	{
		if (!HashHelper.validateHash(password, user.getPassword()))
		{
			throw new ApplicationException("Login error");
		}
				
		
	}

}
