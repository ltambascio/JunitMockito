import static org.junit.Assert.assertEquals;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Exercise 3.11.2 - Create a new empty project and create a simple test class
 * with a single test method containing some assertions.
 * 
 * @author	Larry Tambascio
 */
@RunWith(JUnitParamsRunner.class)
public class StringReverseTest
{
	
	/**
	 * Creates Object array containing parameters to be passed to test method.
	 * @return	Array of parameters (Object)
	 */
	private Object[] testValues()
	{
		return new Object[] {
				new Object[] {"dcba", StringReverse.reverse("abcd")},
				new Object[] {"lmnop", StringReverse.reverse("ponml")},
				new Object[] {"", StringReverse.reverse("")},
				new Object[] {"1", StringReverse.reverse("1")},
				new Object[] {"aaaaaa", StringReverse.reverse("aaaaaa")}
		};
	}

	/**
	 * Generic, parameterized version of test method.
	 * 
	 * @param	expected	The expected string returned by reverse.
	 * @param	actual		The actual value returned by reverse.
	 */
	@Test
	@Parameters(method = "testValues")
	public void testParametericReverse(String expected, String actual)
	{
		assertEquals(expected, actual);
	}
	
	/**
	 * The reverse method should throw an IllegalArgumentException if a null
	 * string is passed in.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNullParameter()
	{
		StringReverse.reverse(null);
	}

}
