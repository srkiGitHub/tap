package rs.vicko.components;

import org.apache.shiro.SecurityUtils;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.slf4j.Logger;

import rs.vicko.pages.Signin;
import rs.vicko.security.User;

/**
 * Layout component for pages of application tap01.
 */
@Import(stylesheet = "context:layout/layout.css")
public class Layout
{
	/**
	 * The page title, for the <title> element and the <h1> element.
	 */

	@Inject
	private Logger logger;

	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;

	@Property
	private String pageName;

	@Property
	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	private String sidebarTitle;

	@Property
	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	private Block sidebar;

	@Inject
	private ComponentResources resources;

	@Property
	@Inject
	@Symbol(SymbolConstants.APPLICATION_VERSION)
	private String appVersion;

	@Inject
	private Request request;

	@Inject
	private JavaScriptSupport javaScriptSupport;

	public void setupRender()
	{
		//javaScriptSupport.addScript("Menu.init('menu', {'orientation': Menu.HORIZONTAL, 'hidePause': 0.1});");
	}

	public String getClassForPageName()
	{
		return resources.getPageName().equalsIgnoreCase(pageName) ? "current_page_item" : null;
	}

	public String[] getPageNames()
	{
		return new String[] { "Index", "About", "Contact" };
	}

	Object onActionFromLogoutLink()
	{
		logger.info("User is logging out.");
		//		Session session = request.getSession(false);
		//		if (session != null)
		//		{
		//			session.invalidate();
		//		}
		SecurityUtils.getSubject().logout();
		return Signin.class;
	}

	public String getUsername()
	{
		return ((User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal()).getFullName();
	}

}
