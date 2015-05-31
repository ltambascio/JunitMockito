/**
 * FahrenheitCelciusConverter class will convert between Fahrenheit and 
 * Celcius with two static methods.  Needed for exercise 3.11.4.
 * 
 * @author Larry Tambascio
 */
public class FahrenheitCelciusConverter
{
	/**
	 * Convert temperature in celcius to fahrenheit
	 * 
	 * @param	celcius		Temperature in degrees celcius
	 * @return	Corresponding temperature in degrees fahrenheit
	 */
	public static int toFahrenheit(int celcius)
	{
		int fahrenheit = (celcius * 9 / 5) + 32;
		return fahrenheit;
	}
	
	/**
	 * Convert temperature in fahrenheit to celcius
	 * 
	 * @param	fahrenheit	Temperature in degrees fahrenheit
	 * @return	Corresponding temperature in degrees celcius
	 */
	public static int toCelcius(int fahrenheit)
	{
		int celcius = (fahrenheit - 32) * 5 / 9;
		return celcius;
	}
}
