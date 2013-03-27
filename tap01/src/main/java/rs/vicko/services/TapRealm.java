package rs.vicko.services;

import java.util.HashSet;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class TapRealm extends AuthorizingRealm
{

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
		// TODO Auto-generated method stub

		return new SimpleAuthenticationInfo(new User("sasa", "sasa"), "sasa", "TapRealm");

	}

}
