import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Listing 4.1 - Football Team test class
 * 
 * @author Larry Tambascio
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest
{
	/**
	 * Constant for the number of games won.
	 */
	private static final int THREE_GAMES_WON = 3;
	
	/**
	 * Generate parameterized values for constructorShouldSetGamesWon test
	 * 
	 * @return	Values to pass to the test
	 */
	private Object[] nbOfGamesWon()
	{
		return new Object[] {0, 1, 2};
	}

	/**
	 * Verify that the constructor can correctly set the number of games won.
	 */
	@Test
	@Parameters(method = "nbOfGamesWon")
	public void constructorShouldSetGamesWon(int nbOfGamesWon)
	{
		FootballTeam team = new FootballTeam(nbOfGamesWon);
		assertEquals(nbOfGamesWon + " games passed to constructor but " + 
				team.getGamesWon() + " were returned", 
				nbOfGamesWon, team.getGamesWon());
	}
	
	/**
	 * Generate parameterized values for constructorShouldThrowExceptionForIllegalGamesNb test
	 * 
	 * @return	Values to pass to the test
	 */
	private Object[] illegalNbOfGamesWon()
	{
		return new Object[] {-10, -1};
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "illegalNbOfGamesWon")
	public void constructorShouldThrowExceptionForIllegalGamesNb(int illegalNbOfGames)
	{
		new FootballTeam(illegalNbOfGames);
	}

}
