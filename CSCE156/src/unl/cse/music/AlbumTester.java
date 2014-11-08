package unl.cse.music;

import org.joda.time.DateTime;

public class AlbumTester {

	public static void main(String args[]) {

		DateTime relDate = new DateTime(1973, 3, 1, 0, 0, 0);

		Album a; //just creates a reference to an Album type
		
		a = new Album("Closing Time", "Tom Waits", relDate, 20); //creates an Album using the default constructor
		
		//alternate syntax: Album a = new Album();
		
//		a.setTitle("Closing Time");
//		a.setArtist("Tom Waits");
		
		Track t = new Track("Ol' 55", 240);
		//not good: t.lengthInS = -10;
		//t.setLengthInS(-10);
		
		a.addTrack(t, 1);
		a.addTrack(new Track("Track 2", 180), 2);
		
		
		System.out.println("Album's title is " + a.getTitle());
		System.out.println("The Artist is " + a.getArtist());
		System.out.println("It was released on "+a.getReleaseDate().toString());
		System.out.println("It is " + a.getAgeInYears() + " old");
		System.out.println("total running time is " + a.getTotalRunningTimeInS()+"s");
	}
	
}
