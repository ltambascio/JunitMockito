/**
 * Exercise 4.10.1 - Really simple password validator.  The rules are:
 * <ul>
 * <li>The password must have 6 or more characters.</li>
 * <li>The password must end with a number.</li>
 * <li>The password cannot start with a number.</li>
 * </ul>
 * 
 * @author Larry Tambascio
 */
public class PasswordValidator
{
	/**
	 * Method that validates the passed in string for the password rules as 
	 * defined above.  Using a regex to "simplify".
	 * 
	 * @param password	Password to validate
	 * @return	{@code true} if the password is valid, {@code false} otherwise.
	 */
	public static boolean validate(String password)
	{
		if (password.length() < 6)
		{
			return false;
		}
		return password.matches("[a-zA-Z]\\w+\\d");
	}
}
