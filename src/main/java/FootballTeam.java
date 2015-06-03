/**
 * Football Team class that keeps track of how many games the team has won.
 * 
 * @author Larry Tambascio
 */
public class FootballTeam
{
	/**
	 * Member for holding the number of games won.
	 */
	private int gamesWon;
	
	/**
	 * Constructor that accepts the number of games won.
	 * 
	 * @param gamesWon	Number of games the team has won
	 */
	public FootballTeam (int gamesWon)
	{
		if (gamesWon < 0)
		{
			throw new IllegalArgumentException();
		}
		
		this.gamesWon = gamesWon;
	}
	
	/**
	 * Returns the number of games won.
	 * 
	 * @return Games won
	 */
	public int getGamesWon()
	{
		return gamesWon;
	}
}
