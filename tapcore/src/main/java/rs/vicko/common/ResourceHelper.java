package rs.vicko.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class ResourceHelper
{
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(ResourceHelper.class);

	public static String getResourceText(String resourceUrl)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				ResourceHelper.class.getResourceAsStream(resourceUrl)));
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		String line;
		try
		{
			while ((line = br.readLine()) != null)
			{
				if (first)
				{
					first = false;
				}
				else
				{
					sb.append("\n");
				}
				sb.append(line);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException(String.format("There is no resource file %s", resourceUrl));
		}
		return sb.toString();
	}

}
