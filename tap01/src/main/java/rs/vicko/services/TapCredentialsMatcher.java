package rs.vicko.services;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

import rs.vicko.common.HashHelper;
import rs.vicko.security.User;

public class TapCredentialsMatcher implements CredentialsMatcher
{

	private static Logger logger = Logger.getLogger(TapCredentialsMatcher.class);

	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
	{
		User user = (User) info.getPrincipals().getPrimaryPrincipal();
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String password = new String(upToken.getPassword());

		logger.debug(String.format("Entered password is \"%s\"", password));
		return HashHelper.validateHash(password, user.getPassword());
	}

}
