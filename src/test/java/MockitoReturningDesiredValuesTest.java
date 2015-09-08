import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Listing 5.5 - Specifying what a mock will return.
 * 
 * @author Larry Tambascio
 */
public class MockitoReturningDesiredValuesTest
{

	private Car myFerrari = mock(Car.class);

	@Test
	public void testStubbing()
	{
		assertFalse("new test double should return false as boolean",
				myFerrari.needsFuel());
		
		when(myFerrari.needsFuel()).thenReturn(true);
		
		assertTrue("after instructed test double should return what we want",
				myFerrari.needsFuel());
	}

}
