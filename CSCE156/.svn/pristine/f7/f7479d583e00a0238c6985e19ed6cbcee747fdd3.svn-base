package unl.cse.hashing;

import java.util.concurrent.Callable;

public class CallableDistance implements Callable<Double> {

	private final Location origin;
	private final Location destination;
	
	public CallableDistance(Location origin, Location destination) {
		this.origin = origin;
		this.destination = destination;
	}
	@Override
	public Double call() throws Exception {
		return GoogleMapsUtils.getDistance(this.origin, this.destination);
	}

}
