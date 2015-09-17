package testdoubles;

/**
 * Listing 5.37 - Phone class
 * @author Larry Tambascio
 */
public class Phone
{
	private final boolean mobile;
	private final String number;
	
	public Phone(String number, boolean mobile)
	{
		this.number = number;
		this.mobile = mobile;
	}
	
	public boolean isMobile()
	{
		return mobile;
	}

}
