/**
 * Section 5.1 - Introducing Mockito
 * Very simple car interface (Listing 5.1)
 * 
 * @author Larry Tambascio
 */
public interface Car
{
	boolean needsFuel();
	
	double getEngineTemperature();
	
	void driveTo(String destination);
}
