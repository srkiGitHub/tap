package rs.vicko.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>
{

	public User mapRow(ResultSet rs, int ROWnUM) throws SQLException
	{

		return new User(rs.getInt("id"), rs.getString("full_name"), rs.getString("username"), rs.getString("password"));

	}

}
