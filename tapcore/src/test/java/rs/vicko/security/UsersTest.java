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
}
