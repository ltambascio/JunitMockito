import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Listing 4.1 - Football Team test class
 * 
 * @author Larry Tambascio
 */
public class FootballTeamTest
{
	/**
	 * Constant for the number of games won.
	 */
	private static final int THREE_GAMES_WON = 3;

	/**
	 * Verify that the constructor can correctly set the number of games won.
	 */
	@Test
	public void constructorShouldSetGamesWon()
	{
		FootballTeam team = new FootballTeam(THREE_GAMES_WON);
		assertEquals(THREE_GAMES_WON + " games passed to constructor but " + 
				team.getGamesWon() + " were returned", 
				THREE_GAMES_WON, team.getGamesWon());
	}

}
