package exercises;

/**
 * Collaborator for Listing 5.43 UserServiceImpl
 * 
 * @author Larry Tambascio
 */
public interface User
{

	public String getPassword();

	public void setPassword(String passwordMd5);

}
