package raceresults;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Section 5.4 - TDD with test doubles
 * 
 * @author Larry Tambascio
 */
public class RaceResultsServiceTest
{

	@Test
	public void subscribedClientShouldReceiveMessages()
	{
		RaceResultsService raceResults = new RaceResultsService();
		Client client = mock(Client.class);
		Message message = mock(Message.class);
		
		raceResults.addSubscriber(client);
		raceResults.send(message);
		
		verify(client).receive(message);
	}

}
