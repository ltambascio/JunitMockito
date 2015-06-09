import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class BookingSystemTest
{
	private BookingSystem booking;
	
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

}
