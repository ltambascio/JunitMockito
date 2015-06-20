import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest
{
	private BookingSystem booking;
	
	/**
	 * Instantiate the booking system for the tests
	 */
	@Before
	public void setUp()
	{
		booking = new BookingSystem();
	}

	/**
	 * After initial creation, the booking system should not have anything 
	 * booked.
	 */
	@Test
	public void validateEmptyBookedHours()
	{
		assertEquals(0, booking.listBookedHours().size());
	}
	
	@Test
	public void validateOneBookedBlock()
	{
		booking.reserve(1);
		assertEquals(1, booking.listBookedHours().size());
	}
	
	/**
	 * Test to validate that a second booking on an hour already reserved fails
	 * or returns false.
	 */
	@Test
	public void ensureSecondBookingOnHourFails()
	{
		assertTrue(booking.reserve(1));
		assertFalse(booking.reserve(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method="fetchIllegalHours")
	public void onlyValidHoursAllowed(int hour)
	{
		booking.reserve(hour);
	}
	
	private Object[] fetchIllegalHours()
	{
		return new Object[] {-1, -12, -36, 24, 255};
	}

}
