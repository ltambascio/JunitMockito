package testdoubles;

/**
 * Listing 5.41 - Phone class with enahnced constructor
 * 
 * @author Larry Tambascio
 */
public class Phone
{
	private final boolean mobile;
	private final String number;
	
	public Phone(String number)
	{
		this.number = number;
		this.mobile = number.startsWith("+") && number.endsWith("9");
	}
	
	public boolean isMobile()
	{
		return mobile;
	}

}
