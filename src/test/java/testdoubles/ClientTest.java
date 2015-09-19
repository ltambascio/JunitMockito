package testdoubles;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Listing 5.39 - No Test Doubles
 * 
 * @author Larry Tambascio
 */
public class ClientTest
{
	final static String ANY_NUMBER = "999-888-7777";
	final static Phone MOBILE_PHONE = new Phone(ANY_NUMBER, true);
	final static Phone STATIONARY_PHONE = new Phone(ANY_NUMBER, false);
	
	Client client = new Client();

	@Test
	public void shouldReturnTrueIfClientHasMobile()
	{
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
