package unl.cse.classes;

import org.joda.time.DateTime;

public class AlbumDemo {

	public static void main(String args[]) {
		
		Album a = new Album(new DateTime(1978, 7, 9, 0, 0, 0));
		System.out.println(a + " is " + a.getAgeInYears() + " years old");
	}
}
