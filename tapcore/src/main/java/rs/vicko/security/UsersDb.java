package rs.vicko.security;

interface UsersDb
{
	User getUser(int id);
	
	User getUser(String username);
}
