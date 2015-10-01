package raceresults;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Exercise 5.7.2 - Enhanced version.
 * 
 * @author Larry Tambascio
 */
public class RaceResultsService
{
	public static final String DEFAULT_CATEGORY = "Default";
	private Logger log;
	private Map<String,Collection<Client>> clientCat = new HashMap<String,Collection<Client>>();
	//private Collection<Client> clients = new HashSet<Client>();

	/**
	 * Constructor to initialize the default category.
	 */
	public RaceResultsService(Logger logger)
	{
		this.log = logger;
		clientCat.put(DEFAULT_CATEGORY, new HashSet<Client>());
	}

	public void addSubscriber(Client client)
	{
		clientCat.get(DEFAULT_CATEGORY).add(client);
	}

	public void send(Message message)
	{
		send(message, DEFAULT_CATEGORY);
	}

	public void removeSubscriber(Client client)
	{
		removeSubscriber(client, DEFAULT_CATEGORY);
	}

	public void addSubscriber(Client client, String category)
	{
		Collection<Client> clients;
		
		if (clientCat.containsKey(category))
		{
			clients = clientCat.get(category);
		}
		else
		{
			clients = new HashSet<Client>();
			clientCat.put(category, clients);
		}
		clients.add(client);
	}
	
	public void removeSubscriber(Client client, String category)
	{
		Collection<Client> clients;
		
		if (clientCat.containsKey(category))
		{
			clients = clientCat.get(category);
			if (clients.contains(client))
			{
				clients.remove(client);
			}
			else
			{
				throw new RuntimeException("No client found for given category");
			}
		}
		else
		{
			throw new RuntimeException("Category not found: " + category);
		}
	}
	
	public void send(Message message, String category)
	{
		for (Client client : clientCat.get(category))
		{
			log.debug(new Date(), message);
			client.receive(message);
		}
	}

}
