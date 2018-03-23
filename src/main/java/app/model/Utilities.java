package app.model;

import java.io.UnsupportedEncodingException;

public class Utilities
{
	public static String getCP1251String(String utf8String)
	{
		if (utf8String == null)
			return null;
		else
			return encode(utf8String, "UTF-8", "windows-1251");
	}
	
	public static String getUTF8String(String cp1251String)
	{
		if (cp1251String == null)
			return null;
		else
			return encode(cp1251String,"windows-1251", "UTF-8");
	}
	
	private static String encode(String line, String sourceCP, String destCP)
	{
		String result = null;
		
		try
		{
			result = new String(line.getBytes(sourceCP), destCP);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
