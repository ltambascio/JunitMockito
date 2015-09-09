import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * Listing 5.3 - Basic example of mocking an interface
 * 
 * @author Larry Tambascio
 */
public class FirstMockitoTest
{
	private Car myFerrari = mock(Car.class);

	@Test
	public void testIfCarIsACar()
	{
		assertTrue(myFerrari instanceof Car);
	}

}
