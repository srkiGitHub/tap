package rs.vicko.tapws;

import javax.jws.WebParam;
import javax.jws.WebService;

import rs.vicko.security.User;
import rs.vicko.security.Users;
import rs.vicko.security.UsersImpl;

@WebService(endpointInterface = "rs.vicko.tapws.TapWebService")
//@HandlerChain(file = "handlers.xml")
public class TapWebServiceImpl implements TapWebService
{

	@Override
	public String sayHello(@WebParam(name = "name") String name)
	{
		 return "Hello " + name + "!";
	}

	@Override
	public User getUserbyName(@WebParam(name = "name") String name)
	{
		
		return (new UsersImpl()).getUser(name);
	}

}
