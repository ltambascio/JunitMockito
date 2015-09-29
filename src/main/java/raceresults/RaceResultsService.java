package raceresults;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RaceResultsService
{
	public static final String DEFAULT_CATEGORY = "Default";
	private Map<String,Collection<Client>> clientCat = new HashMap<String,Collection<Client>>();
	//private Collection<Client> clients = new HashSet<Client>();

	/**
	 * Constructor to initialize the default category.
	 */
	public RaceResultsService()
	{
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
		clientCat.get(DEFAULT_CATEGORY).remove(client);
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
	
	public void send(Message message, String category)
	{
		for (Client client : clientCat.get(category))
			client.receive(message);
	}

}
