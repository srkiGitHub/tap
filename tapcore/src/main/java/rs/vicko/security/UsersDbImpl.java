package rs.vicko.security;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import rs.vicko.common.ResourceHelper;

public class UsersDbImpl extends JdbcDaoSupport implements UsersDb
{

	private static Logger logger = Logger.getLogger(UsersDbImpl.class);

	public User getUser(int id)
	{
		String sql = ResourceHelper.getResourceText("/sql/getUserById.sql");
		logger.debug(String.format("get usr  by id, sql = \n%s", sql));

		List<User> users = getJdbcTemplate().query(sql, new Object[] { id }, new UserRowMapper());
		if (users.size() == 0)
		{
			return null;
		}

		return users.get(0);
	}

	public User getUser(String username)
	{
		String sql = ResourceHelper.getResourceText("/sql/getUserByUsername.sql");
		logger.debug(String.format("get usr  by username, sql = \n%s", sql));

		List<User> users = getJdbcTemplate().query(sql, new Object[] { username }, new UserRowMapper());
		if (users.size() == 0)
		{
			return null;
		}

		return users.get(0);
	}

}
