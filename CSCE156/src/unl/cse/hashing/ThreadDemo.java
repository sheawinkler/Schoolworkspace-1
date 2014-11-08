package unl.cse.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import unl.cse.utils.Pair;

public class ThreadDemo {

	public static void main(String args[]) {
		
		ExecutorService executor = null;
		
		try {
			executor = Executors.newFixedThreadPool(10);

			Map<Pair<Location, Location>, Future<Double>> distances = new HashMap<Pair<Location, Location>, Future<Double>>();
			
			long start, end;
			
			int n = 10; //Google limits us to 100 queries per 10 seconds
			//CacheDemo.locations.size();
			start = System.currentTimeMillis();
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					Location orig = CacheDemo.locations.get(i);
					Location dest = CacheDemo.locations.get(j);
					Callable<Double> futureDistance = new CallableDistance(orig, dest);
					Future<Double> submit = executor.submit(futureDistance);
					distances.put(Pair.make(orig, dest), submit);
				}
			}
			for(Pair<Location, Location> pair : distances.keySet()) {
				System.out.println(pair.getFirst()+ " -> " + pair.getSecond() + " = " + distances.get(pair).get() + "km");
			}
			end = System.currentTimeMillis();
			
			System.out.println("It took "+( (end - start) / 1000.0 )+" seconds to compute "+( n * (n-1) / 2 )+" distances.");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}
}
