import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * Exercise 3.11.3 - HashMap tests
 * <p>Write unit tests which will verify the following properties of the 
 * {@code java.util.HashMap} class:
 * <ul><li>an object stored with the {@code put()} method can be retrieved with 
 * the {@code get()} method.</li>
 * <li>adding a second object with the same key results in the old value being 
 * replaced</li>
 * <li>the {@code clear()} method removes all its content</li>
 * <li>the {@code null} value can be used as a key</li>
 * </ul>
 * 
 * @author Larry Tambascio
 */
public class HashMapTest
{
	private HashMap<String, String> testMap;
	
	/**
	 * Initialize the test fixture.
	 */
	@Before
	public void setUp()
	{
		testMap = new HashMap<String, String>();
	}

	/**
	 * Test to verify that an object stored with the {@code put()} method can be
	 * retrieved with the {@code get()} method.
	 */
	@Test
	public void testObjectStoredRetrievedWithGet()
	{
		testMap.put("key", "test value");
		assertEquals("test value", testMap.get("key"));
	}
	
	/**
	 * Test to verify that adding a second object with the same key results in 
	 * the old value being replaced.
	 */
	@Test
	public void testSameKeyReplacesOldValue()
	{
		testMap.put("key", "original value");
		testMap.put("key", "replaced value");
		
		assertEquals("replaced value", testMap.get("key"));
	}
	
	/**
	 * Test to verify that the {@code clear()} method removes all it's content.
	 */
	@Test
	public void testClearMethod()
	{
		testMap.put("key1", "value1");
		testMap.put("key2", "value2");
		testMap.put("key3", "value3");
		testMap.put("key4", "value4");
		
		assertEquals(4, testMap.size());	// Verify 4 items added.
		
		testMap.clear();
		
		assertEquals(0, testMap.size());
		
	}
	
	/**
	 * Test verifying {@code null} can be used as a key value
	 */
	@Test
	public void testNullValueAsKey()
	{
		testMap.put(null, "value associated with null");
		
		assertEquals("value associated with null", testMap.get(null));
	}

}
