package rs.vicko.common;

import java.security.MessageDigest;
import java.security.SecureRandom;

import org.apache.log4j.Logger;

public class HashHelper
{
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(HashHelper.class);

	public static String calculateHash(String input)
	{
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return calculateHashForSalt(input, salt) + asHex(salt);
	}

	private static String calculateHashForSalt(String input, byte[] salt)
	{
		MessageDigest mda;
		try
		{
			mda = MessageDigest.getInstance("SHA-512");
		}
		catch (Exception e)
		{
			return null; // never going to happen unless someone changes SHA-512
		}
		mda.reset();
		mda.update(salt);
		byte[] digest = mda.digest(input.getBytes());
		return asHex(digest);
	}

	public static Boolean validateHash(String input, String hash)
	{
		return hash.length() == 160
				&& hash.substring(0, 128).equals(calculateHashForSalt(input, asBytes(hash.substring(128))));
	}

	private static String asHex(byte[] buf)
	{
		StringBuffer strbuf = new StringBuffer(buf.length * 2);

		for (byte b : buf)
		{
			strbuf.append(String.format("%02X", b));
		}
		return strbuf.toString();
	}

	private static byte[] asBytes(String str)
	{
		if ((str.length() % 2) == 1)
		{
			str = "0" + str; // pad leading 0 if needed
		}
		byte[] buf = new byte[str.length() / 2];
		int i = 0;

		for (char c : str.toCharArray())
		{
			byte b = Byte.parseByte(String.valueOf(c), 16);
			buf[i / 2] |= (b << (((i % 2) == 0) ? 4 : 0));
			i++;
		}
		return buf;
	}

}
