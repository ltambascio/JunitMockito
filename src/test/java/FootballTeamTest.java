import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

	/**
	 * Verify that illegal (negative) values cause an {@code IllegalArgumentException}.
	 * 
	 * @param illegalNbOfGames	Invalid values for the constructor.
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "illegalNbOfGamesWon")
	public void constructorShouldThrowExceptionForIllegalGamesNb(int illegalNbOfGames)
	{
		new FootballTeam(illegalNbOfGames);
	}
	
	/**
	 * Test to verify that {@code FootballTeam} implements {@code Comparable}.
	 */
	@Test
	public void shouldBePossibleToCompareTeams()
	{
		FootballTeam team  = new FootballTeam(123);
		
		assertTrue("FootbalTeam should implement Comparable",
				team instanceof Comparable);
	}
	
	/**
	 * Verify that a team with more wins should compare to as greater than a 
	 * team with fewer wins.
	 */
	@Test
	public void teamsWithMoreMatchesWonShouldBeGreater()
	{
		FootballTeam team_2 = new FootballTeam(2);
		FootballTeam team_3 = new FootballTeam(3);
		
		assertTrue(team_3.compareTo(team_2) > 0);
	}

	/**
	 * Verify that a team with fewer wins should compare to as lesser than a 
	 * team with more wins.
	 */
	@Test
	public void teamsWithFewerMatchesWonShouldBeLesser()
	{
		FootballTeam team_2 = new FootballTeam(2);
		FootballTeam team_3 = new FootballTeam(3);
		
		assertTrue(team_2.compareTo(team_3) < 0);
	}

	/**
	 * Verify that a team with the same wins should compare to as 0 against
	 * another team with the same wins.
	 */
	@Test
	public void teamsWithSameMatchesWonShouldBeEqual()
	{
		FootballTeam team_A = new FootballTeam(2);
		FootballTeam team_B = new FootballTeam(2);
		
		assertTrue(team_A.compareTo(team_B) == 0);
	}

}
