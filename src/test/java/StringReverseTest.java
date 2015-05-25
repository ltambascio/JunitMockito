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
	
	private Object[] testValues()
	{
		return new Object[] {
				new Object[] {"dcba", StringReverse.reverse("abcd")},
				new Object[] {"lmnop", StringReverse.reverse("ponml")}
		};
	}

	/**
	 * 
	 */
	@Test
	@Parameters(method = "testValues")
	public void testSimpleExpectedReverse(String expected, String actual)
	{
		assertEquals(expected, actual);
	}

}
