/**
 * 
 */
package testdoubles;

import java.util.ArrayList;
import java.util.List;

/**
 * Listing 5.38 - Client class of phone.
 * 
 * @author Larry Tambascio
 */
public class Client
{
	private final List<Phone> phones = new ArrayList<Phone>();
	
	public void addPhone(Phone phone)
	{
		phones.add(phone);
	}
	
	public boolean hasMobile()
	{
		for (Phone phone : phones)
		{
			if (phone.isMobile())
			{
				return true;
			}
		}
		return false;
	}
}
