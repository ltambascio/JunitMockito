import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


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

}
