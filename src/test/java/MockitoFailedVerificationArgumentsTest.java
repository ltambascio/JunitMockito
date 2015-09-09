import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Listing 5.8 - Failed verification test
 * 
 * @author Larry Tambascio
 */
public class MockitoFailedVerificationArgumentsTest
{

	private Car myFerrari = mock(Car.class);

	@Test
	public void testVerificationFailureArguments()
	{
		myFerrari.driveTo("Sweet home Alabama");
		
		verify(myFerrari).driveTo("Sweet home Honolulu");
	}

}
