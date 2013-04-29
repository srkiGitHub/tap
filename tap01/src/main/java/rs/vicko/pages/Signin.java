package rs.vicko.pages;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.alerts.AlertManager;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import org.tynamo.security.services.SecurityService;

public class Signin
{

	@Property
	@Persist
	private String username;

	@Property
	private String password;

	@Inject
	private SecurityService securityService;

	@Inject
	private AlertManager alertManager;

	public String onActionFromLoginForm()
	{
		Subject currentUser = securityService.getSubject();
		//alertManager.success(currentUser.toString());

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		try
		{
			currentUser.login(token);
		}
		catch (Exception e)
		{
			alertManager.error(e.getMessage());
			return null;
		}

		return "Index";
	}
}