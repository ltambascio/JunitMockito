import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Listing 5.7 - Verifications
 * 
 * @author Larry Tambascio
 */
public class MockitoVerificationTest
{

	private Car myFerrari = mock(Car.class);

	@Test
	public void test()
	{
		myFerrari.driveTo("Sweet home Alabama");
		myFerrari.needsFuel();
		
		verify(myFerrari).driveTo("Sweet home Alabama");
		verify(myFerrari).needsFuel();
	}

}
