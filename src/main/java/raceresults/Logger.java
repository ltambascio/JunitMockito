package raceresults;

import java.util.Date;

/**
 * Exercise 5.7.2 - Logger interface to add some logging capability, but only to
 * validate the behavior.
 *
 * @author Larry Tambascio
 */
public interface Logger
{

	public void debug(Date date, Message message);

}
