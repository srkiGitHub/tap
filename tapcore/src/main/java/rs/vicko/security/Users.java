package rs.vicko.security;

public interface Users
{
	User getUser(int id);

	User getUser(String username);

	String generatePasswordHash(String password);
	
	void login(User user, String password);
}
