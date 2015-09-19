package testdoubles;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Listing 5.40 - Client test with test doubles
 * 
 * @author Larry Tambascio
 */
public class ClientTest
{
	final static Phone MOBILE_PHONE = mock(Phone.class);
	final static Phone STATIONARY_PHONE = mock(Phone.class);
	
	Client client = new Client();

	@Test
	public void shouldReturnTrueIfClientHasMobile()
	{
		when(MOBILE_PHONE.isMobile()).thenReturn(true);
		
		client.addPhone(MOBILE_PHONE);
		client.addPhone(STATIONARY_PHONE);
		assertTrue(client.hasMobile());
	}
	
	@Test
	public void shouldReturnFalseIfClientHasNoMobile()
	{
		client.addPhone(STATIONARY_PHONE);
		assertFalse(client.hasMobile());
	}

}
