import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Listing 5.8 - Failed verification test
 * 
 * @author Larry Tambascio
 */
public class MockitoFailedVerificationTest
{

	private Car myFerrari = mock(Car.class);

	@Test
	public void testVerificationFailure()
	{
		myFerrari.needsFuel();
		
		verify(myFerrari).getEngineTemperature();
	}

}
