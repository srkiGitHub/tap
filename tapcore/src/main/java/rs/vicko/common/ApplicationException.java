package rs.vicko.common;

import org.apache.log4j.Logger;

public class ApplicationException extends RuntimeException
{

	private static Logger logger = Logger.getLogger(ApplicationException.class);
	private static final long serialVersionUID = -3467639544459129126L;

	public ApplicationException(String message)
	{
		super(message);
		logger.error(message);
	}
}
