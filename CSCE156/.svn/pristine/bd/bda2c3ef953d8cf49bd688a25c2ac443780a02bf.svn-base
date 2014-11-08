package unl.cse.music;

public class Track {

	private String trackTitle;
	private int lengthInS;
	
	public Track(String trackTitle, int lengthInS) {
		this.setTrackTitle(trackTitle);
		this.setLengthInS(lengthInS);
	}

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}

	public int getLengthInS() {
		return lengthInS;
	}

	public void setLengthInS(int lengthInS) {
		if(lengthInS < 0) {
			throw new IllegalArgumentException("Track lengths cannot be negative");
		}
		this.lengthInS = lengthInS;
	}
	
}
