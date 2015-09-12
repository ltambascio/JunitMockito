package messenger;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Section 5.3 - Test sample Messenger class using a variety of test doubles.
 * Listing 5.16
 * 
 * @author Larry Tambascio
 */
public class MessengerTest
{
	private static final String CLIENT_EMAIL = "someone@email.com";
	private static final String MSG_CONTENT = "Dear John, You are fired!";

	@Test
	public void testMessenger()
	{
		Template template = mock(Template.class);
		Client client = mock(Client.class);
		MailServer mailServer = mock(MailServer.class);
		TemplateEngine templateEngine = mock(TemplateEngine.class);
		
		Messenger sut = new Messenger(mailServer, templateEngine);
		
		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		when(templateEngine.prepareMessage(template, client)).
				thenReturn(MSG_CONTENT);
		
		sut.sendMessage(client, template);
		
		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
	}

}
