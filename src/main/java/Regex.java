import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 4.10.2 - Regex
 * <p>Has method for extracting 3 digit numbers from any string.
 * 
 * @author Larry Tambascio
 */
public class Regex
{
	/**
	 * On the off chance that any other method might want this {@code Pattern}
	 * as a constant.
	 */
	private static final Pattern p = Pattern.compile("\\d{3}");

	/**
	 * Method to return an array of all 3 digit numbers found in the string 
	 * passed in.
	 * 
	 * @param source	String to search through
	 * @return	Array of 3 digit numbers found
	 */
	public static String[] threeDigitNumbers(String source)
	{
		ArrayList<String> retVal = new ArrayList<String>();
		
		Matcher m = p.matcher(source);
		
		while (m.find())
		{
			retVal.add(m.group());
		}
		
		String[] retValArray = new String[retVal.size()];
		return retVal.toArray(retValArray);
	}
}
