package unl.cse.classes;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class Album {

	private String title;
	private DateTime releaseDate;
	
	public Album(DateTime dt) {
		this.releaseDate = dt;
	}
	
	public int getAgeInYears() {
		Duration d = new Duration(releaseDate, new DateTime());
		int result = (int) (d.getStandardDays() / 365.25);
		return result;
	}
}
