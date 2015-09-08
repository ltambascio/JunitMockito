import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Listing 5.6 - Throwing an exception from the mock.
 * 
 * @author Larry Tambascio
 */
public class MockitoThrowingExceptionsTest
{

	private Car myFerrari = mock(Car.class);

	@Test(expected=RuntimeException.class)
	public void testException()
	{
		when(myFerrari.needsFuel()).thenThrow(new RuntimeException());
		
		myFerrari.needsFuel();
	}

}
