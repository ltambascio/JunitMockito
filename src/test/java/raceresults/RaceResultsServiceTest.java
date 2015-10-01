package raceresults;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

import java.sql.Date;

import org.junit.Test;

/**
 * Section 5.4 - TDD with test doubles
 * 
 * @author Larry Tambascio
 */
public class RaceResultsServiceTest
{

	private Logger logger = mock(Logger.class);
	private RaceResultsService raceResults = new RaceResultsService(logger);
	private Client clientA = mock(Client.class, "clientA");
	private Client clientB = mock(Client.class, "clientB");
	private Message message = mock(Message.class);

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

	/**
	 * Verify that a client that has unsubscribed won't get any messages.
	 */
	@Test
	public void unsubscribedClientShouldNotReceiveMessages()
	{
		raceResults.addSubscriber(clientA);
		raceResults.removeSubscriber(clientA);
		raceResults.send(message);
		
		verify(clientA, never()).receive(message);
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
	
	// Adding the concept of race categories
	/**
	 * Verify a simple category scenario
	 */
	@Test
	public void categorySubscriber()
	{
		raceResults.addSubscriber(clientA, "categoryA");
		
		raceResults.send(message, "categoryA");
		
		verify(clientA).receive(message);
		verify(clientB, never()).receive(message);
	}
	
	/**
	 * Verify that different categories go to their respective clients.
	 */
	@Test
	public void multipleCategories()
	{
		raceResults.addSubscriber(clientA, "categoryA");
		raceResults.addSubscriber(clientB, "categoryB");
		
		raceResults.send(message, "categoryA");
		raceResults.send(message, "categoryB");
		
		verify(clientA, times(1)).receive(message);
		verify(clientB, times(1)).receive(message);
	}

	/**
	 * Verify that different categories go to their respective clients, and that
	 * a category will go to multiple clients.
	 */
	@Test
	public void multipleCategoriesMultipleTimes()
	{
		raceResults.addSubscriber(clientA, "categoryA");
		raceResults.addSubscriber(clientB, "categoryA");
		raceResults.addSubscriber(clientB, "categoryB");
		raceResults.addSubscriber(clientB);
		
		raceResults.send(message, "categoryA");
		raceResults.send(message, "categoryB");
		raceResults.send(message);
		
		verify(clientA, times(1)).receive(message);
		verify(clientB, times(3)).receive(message);
	}
	
	/**
	 * Test to validate logger DOC, and it will also validate multiple messsages
	 * for different categories.
	 */
	@Test
	public void validateLogger()
	{
		raceResults.addSubscriber(clientA, "categoryA");
		raceResults.addSubscriber(clientB, "categoryB");
		
		raceResults.send(message, "categoryA");
		raceResults.send(message, "categoryB");
		raceResults.send(message, "categoryA");
		raceResults.send(message, "categoryB");
		raceResults.send(message, "categoryA");
		raceResults.send(message, "categoryB");
		raceResults.send(message, "categoryB");
		raceResults.send(message, "categoryB");
		raceResults.send(message, "categoryB");
		
		verify(clientA, times(3)).receive(message);
		verify(clientB, times(6)).receive(message);
		
		verify(logger, times(9)).debug(any(Date.class), eq(message));
	}
	
	@Test(expected=RuntimeException.class)
	public void removeUnknownClient()
	{
		raceResults.removeSubscriber(clientA);
	}

	@Test(expected=RuntimeException.class)
	public void removeClientFromUnkownCategory()
	{
		raceResults.addSubscriber(clientA, "categoryA");
		
		raceResults.removeSubscriber(clientA, "categoryB");
	}

}
