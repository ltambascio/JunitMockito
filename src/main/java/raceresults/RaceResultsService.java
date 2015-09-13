package raceresults;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService
{
	private Collection<Client> clients = new HashSet<Client>();

	public void addSubscriber(Client client)
	{
		this.clients.add(client);
	}

	public void send(Message message)
	{
		for (Client client : clients)
			client.receive(message);
	}

}
