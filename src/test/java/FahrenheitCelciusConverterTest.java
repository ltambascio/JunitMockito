import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Listing 3.17 - Test class to test temperature conversion class.
 * 
 * @author	Larry Tambascio
 */
@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest
{
	/**
	 * Parameter value method for converting Celcius to Fahrenheit
	 * @return	Test values
	 */
	private Object[] toFahrenheitValues()
	{
		return new Object[] {
				new Object[] {32,0},
				new Object[] {98, 37},
				new Object[] {212, 100}
		};
	}

	/**
	 * Verify conversion to Fahrenheit
	 */
	@Test
	@Parameters(method="toFahrenheitValues")
	public void shouldConvertCelciusToFahrneheit(int fahrenheit, int celcius)
	{
		assertEquals(fahrenheit, FahrenheitCelciusConverter.toFahrenheit(celcius));
	}

	/**
	 * Parameter value method for converting Celcius to Fahrenheit
	 * @return	Test values
	 */
	private Object[] toCelciusValues()
	{
		return new Object[] {
				new Object[] {0, 32},
				new Object[] {37, 100},
				new Object[] {100, 212}
		};
	}

	/**
	 * Verify conversion to Celcius
	 */
	@Test
	@Parameters(method="toCelciusValues")
	public void shouldConvertFahrenheitToCelcius(int celcius, int fahrenheit)
	{
		assertEquals(celcius, FahrenheitCelciusConverter.toCelcius(fahrenheit));
	}
}
