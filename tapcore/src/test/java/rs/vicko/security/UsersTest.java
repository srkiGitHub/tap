package rs.vicko.security;

import org.apache.log4j.Logger;
import org.junit.Test;

public class UsersTest
{
	private static Logger logger = Logger.getLogger(UsersTest.class);

	@Test
	public void testGetUserById()
	{
		Users users = new UsersImpl();
		User user = users.getUser(1);

		logger.debug(String.format("User id=1 is %s", user.getFullName()));

	}

	@Test
	public void testGetUserByUsername()
	{
		Users users = new UsersImpl();
		User user = users.getUser("sasa");

		logger.debug(String.format("User with username sasa is %s", user.getFullName()));

	}

	
	@Test
	public void testGeneratePasswordHash()
	{
		Users users = new UsersImpl();

		logger.debug(users.generatePasswordHash("sasa"));

	}
	
	@Test
	public void testLogin()
	{
		Users users = new UsersImpl();
		User user = users.getUser("sasa");

		users.login(user, "sasa");
		logger.debug("User logged");

	}
	
	

}
