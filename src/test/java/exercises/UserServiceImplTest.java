package exercises;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Exercise 5.7.1 - UserServiceImpl Test
 * <p>Happy path test verifying that the user get their new password, and that
 * it was saved through the DAO.
 * 
 * @author Larry Tambascio
 */
public class UserServiceImplTest
{
	private UserServiceImpl userService;
	
	private UserDAO userDAO = mock(UserDAO.class);
	private SecurityService secService = mock(SecurityService.class);
	private User user = mock(User.class);
	
	@Test
	public void testAssignPassword() throws Exception
	{
		userService = new UserServiceImpl(userDAO, secService);
		when(user.getPassword()).thenReturn("password");
		when(secService.md5("password")).thenReturn("md5Password");
		
		userService.assignPassword(user);
		
		verify(user).setPassword("md5Password");
		verify(userDAO).updateUser(user);
	}

}
