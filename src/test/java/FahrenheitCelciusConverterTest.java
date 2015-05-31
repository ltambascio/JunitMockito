import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Listing 3.17 - Test class to test temperature conversion class.
 * 
 * @author	Larry Tambascio
 */
public class FahrenheitCelciusConverterTest
{

	/**
	 * Verify conversion to Fahrenheit
	 */
	@Test
	public void shouldConvertCelciusToFahrneheit()
	{
		assertEquals(32, FahrenheitCelciusConverter.toFahrenheit(0));
		assertEquals(98, FahrenheitCelciusConverter.toFahrenheit(37));
		assertEquals(212, FahrenheitCelciusConverter.toFahrenheit(100));
	}

	/**
	 * Verify conversion to Celcius
	 */
	@Test
	public void shouldConvertFahrenheitToCelcius()
	{
		assertEquals(0, FahrenheitCelciusConverter.toCelcius(32));
		assertEquals(37, FahrenheitCelciusConverter.toCelcius(100));
		assertEquals(100, FahrenheitCelciusConverter.toCelcius(212));
	}
}
