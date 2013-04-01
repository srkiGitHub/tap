package rs.vicko.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelper
{
	private SpringHelper()
	{

	}

	private static ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-module.xml");

	public static ApplicationContext getApplicationContext()
	{
		return context;
	}
}
