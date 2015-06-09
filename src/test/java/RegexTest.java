import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Exercise 4.10.2 - Regex
 * <p>Validate method that returns all the three digit numbers from a string.
 * 
 * @author Larry Tambascio
 */
@RunWith(JUnitParamsRunner.class)
public class RegexTest
{
	/**
	 * Method that returns values for the {@link validateRegex} method.
	 * @return	Parameter values
	 */
	private Object[] testValues()
	{
		return new Object[] {
				new Object[] {"abc 12", new String[]{}},
				new Object[] {"cdefg 345 12bb23", new String[]{"345"}},
				new Object[] {"cdefg 345 12bb23 678tt", 
						new String[] {"345", "678"}},
				new Object[] {"cdefg 345 12bb23 678tt9988", 
						new String[] {"345", "678", "998"}}
		};
	}

	/**
	 * Validates the method that extracts 3 digit numbers from a string.
	 * 
	 * @param target	String to search
	 * @param expected	Array of strings expected to be found
	 */
	@Test
	@Parameters(method = "testValues")
	public void validateRegex(String target, String[] expected)
	{
		assertArrayEquals(expected, Regex.threeDigitNumbers(target)); 
	}
	
	/**
	 * Test validating how patterns and matchers work.  This doesn't test any
	 * part of the SUT.
	 */
	@Test
	public void testRegexPatternsAndMatchersForJava()
	{
		Pattern p = Pattern.compile("\\d{3}");
		Matcher m = p.matcher("cdefg 345 12bb23");
		
		assertTrue(m.find());
		assertEquals("345", m.group());
		assertFalse(m.find());
	}

}
