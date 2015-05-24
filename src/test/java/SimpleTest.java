import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Exercise 3.11.1 - Create a new empty project and create a simple test class
 * with a single test method containing some assertions.
 * 
 * @author	Larry Tambascio
 */
public class SimpleTest
{

	/**
	 * Simple test method demonstrating some simple assertions.
	 */
	@Test
	public void simpleTestMethod()
	{
		String testString = "Some test string";
		
		assertEquals(1, 1);
		assertSame(testString, testString);
	}

}
