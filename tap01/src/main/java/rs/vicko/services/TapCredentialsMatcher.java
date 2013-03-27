package rs.vicko.services;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class TapCredentialsMatcher implements CredentialsMatcher

{

	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
	{
		User user = (User) info.getPrincipals().getPrimaryPrincipal();
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		return (new String(upToken.getPassword())).equals(user.getPassword());
	}

}
