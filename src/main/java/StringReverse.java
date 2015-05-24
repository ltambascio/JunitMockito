import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 3.11.2 - String reverse utility method from Listing 3.16 in the
 * book.
 * 
 * @author	Larry Tambascio
 */
public class StringReverse
{
	public static String reverse(String s)
	{
		List<String> tempArray = new ArrayList<String>(s.length());
		for (int i=0; i < s.length(); i++) {
			tempArray.add(s.substring(i, i+1));
		}
		StringBuilder reversedString = new StringBuilder(s.length());
		for (int i = tempArray.size() - 1; i >= 0; i--) {
			reversedString.append(tempArray.get(i));
		}
		return reversedString.toString();
	}
}
