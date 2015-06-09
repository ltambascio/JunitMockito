import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest
{
	/**
	 * Method to return testing values
	 * @return	Valid passwords.
	 */
	private Object[] validPasswords()
	{
		return new Object[] {"password1", "Patriots4", "graduate15"};
	}

	/**
	 * Parameterized test to verify that valid passwords pass.
	 * 
	 * @param password	Password to test
	 */
	@Test
	@Parameters(method = "validPasswords")
	public void testSuccessfulPasswords(String password)
	{
		assertTrue(PasswordValidator.validate(password));
	}

	/**
	 * Method to return testing values
	 * @return	Invalid passwords.
	 */
	private Object[] invalidPasswords()
	{
		return new Object[] {"password", "4Patriots4", "small"};
	}

	/**
	 * Parameterized test to verify that invalid passwords fail.
	 * 
	 * @param password	Password to test
	 */
	@Test
	@Parameters(method = "invalidPasswords")
	public void testInvalidPasswords(String password)
	{
		assertFalse(PasswordValidator.validate(password));
	}

}
