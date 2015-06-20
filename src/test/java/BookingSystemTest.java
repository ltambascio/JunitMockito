import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	
	/**
	 * Validate that one simple reservation works.
	 */
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
	
	/**
	 * Verify that illegal hour values throw exceptions.
	 * 
	 * @param hour	Illegal hour value to attempt to reserve
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method="fetchIllegalHours")
	public void onlyValidHoursAllowed(int hour)
	{
		booking.reserve(hour);
	}
	
	/**
	 * Method for parameterization to test illegal hour values.
	 * 
	 * @return	Array of illegal values
	 */
	private Object[] fetchIllegalHours()
	{
		return new Object[] {-1, -12, -36, 24, 255};
	}
	
	/**
	 * Tests multiple reservations and ensures everything is as expected with 
	 * the {@code listBookedHours} method.
	 */
	@Test
	public void multipleReservations()
	{
		assertTrue(booking.reserve(2));
		assertTrue(booking.reserve(4));
		assertTrue(booking.reserve(18));
		
		List<Integer> reservations = booking.listBookedHours();
		
		assertEquals(3, reservations.size());
		
		assertEquals(2, reservations.get(0).intValue());
		assertEquals(4, reservations.get(1).intValue());
		assertEquals(18, reservations.get(2).intValue());
	}

}
