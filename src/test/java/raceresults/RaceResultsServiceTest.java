package raceresults;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import org.junit.Test;

/**
 * Section 5.4 - TDD with test doubles
 * 
 * @author Larry Tambascio
 */
public class RaceResultsServiceTest
{

	RaceResultsService raceResults = new RaceResultsService();
	Client clientA = mock(Client.class, "clientA");
	Client clientB = mock(Client.class, "clientB");
	Message message = mock(Message.class);

	// zero subscribers
	/**
	 * Test that clients who are not subscribed shouldn't receive a message.
	 */
	@Test
	public void notSubscribedClientShouldNotReceiveMessage()
	{
		verify(clientA, never()).receive(message);
		verify(clientB, never()).receive(message);
	}

	// One client
	/**
	 * Simple receive message for one client
	 */
	@Test
	public void subscribedClientShouldReceiveMessages()
	{
		raceResults.addSubscriber(clientA);
		raceResults.send(message);
		
		verify(clientA).receive(message);
	}
	
	/**
	 * Verify that a client that subscribes multiple times still only gets one
	 * message.
	 */
	@Test
	public void shouldSendOnlyOneMessageToMultiSubscriber()
	{
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientA);
		raceResults.send(message);
		
		verify(clientA).receive(message);
	}

	// two subscribers
	/**
	 * Verify that multiple clients each receive a message
	 */
	@Test
	public void messageShouldBeSentToAllSubscribers()
	{
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);
		raceResults.send(message);
		
		verify(clientA).receive(message);
		verify(clientB).receive(message);
	}
}
