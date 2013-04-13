package rs.vicko.services;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


import rs.vicko.security.User;
import rs.vicko.security.Users;
import rs.vicko.security.UsersImpl;

public class TapRealm extends AuthorizingRealm
{


    private static Logger logger = Logger.getLogger(TapRealm.class);
	
	TapRealm()
	{
		setCredentialsMatcher(new TapCredentialsMatcher());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
	{
		// TODO Auto-generated method stub
		return new SimpleAuthorizationInfo(new HashSet<String>());
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
	{

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		Users users = new UsersImpl();

		User user = users.getUser(upToken.getUsername());
		logger.debug(String.format("Foud user %s", user.getFullName()));
		return new SimpleAuthenticationInfo(user, upToken.getPassword(), "TapRealm");

	}

}
