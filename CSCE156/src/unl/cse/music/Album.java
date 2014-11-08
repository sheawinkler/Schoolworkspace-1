package unl.cse.music;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * 
 * @author cbourke
 *
 */
public class Album {

	private String title;
	private String artist;
	private DateTime releaseDate;
	private Track tracks[];
	
	public Album(String title, String artist, DateTime releaseDate, int numTracks) {
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.tracks = new Track[numTracks];
	}

	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public DateTime getReleaseDate() {
		return this.releaseDate;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
		
	}
	
	public int getAgeInYears() {
		DateTime now = new DateTime();
		Duration age = new Duration(this.releaseDate, now);
		int ageInYears = (int) (age.getStandardDays() / 365.25);
		return ageInYears;
	}
	
	public void addTrack(Track t, int trackNumber) {
		this.tracks[trackNumber-1] = t;
	}
	
	//an alternative:
	public void addTrack(String trackTitle, int lengthInS, int trackNumber) {
		Track t = new Track(trackTitle, lengthInS);
		this.tracks[trackNumber-1] = t;
	}

	public int getTotalRunningTimeInS() {
		int total = 0;
		
		//original: for(int i=0; i<this.tracks.length; i++) {
		for(Track t : this.tracks) {
			if(t != null) {
				total += t.getLengthInS();
			}
		}
		return total;
	}

}
