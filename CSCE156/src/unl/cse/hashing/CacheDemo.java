package unl.cse.hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CacheDemo {

	public static final List<Location> locations = new ArrayList<Location>();
	
	static {
		Scanner s;
		try {
			s = new Scanner(new File("data/mlb_stadiums.dat"));
			while(s.hasNext()) {
				String line = s.nextLine();
				String tokens[] = line.split(",");
				Location l = new Location(tokens[1] + " (" + tokens[0] + ")", tokens[2], tokens[3], tokens[4], tokens[5]);
				locations.add(l);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {

		Hashtable<Integer, String> t = new Hashtable<Integer, String>();
		t.put(1, "one");
		t.put(2, "two");
		//Hashtable implements Map!

		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(1, "one");
		m.put(2, "two");
		
		LRUCache<Integer, String> cache = new LRUCache<Integer, String>(5);

		cache.put(10, "ten");
		cache.put(20, "twenty");
		cache.put(30, "thirty");
		cache.put(40, "forty");
		cache.put(50, "fifty");

		System.out.println(cache);

		for(int i=10; i<50; i+=10)
			System.out.println("From cache: "+cache.get(i));
		
		cache.put(60, "sixty");
		System.out.println(cache);

		//takes about 3-4 minutes to compute all 435 one way distances
		//takes 14.557 seconds to do 45 distances, 0.0050 seconds to recall, but only 1.796s to do in parallel
		int n = 10; //locations.size();
		long start, end;
		start = System.currentTimeMillis();
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				GoogleMapsUtils.getDistance(locations.get(i), locations.get(j));
			}
		}
		end = System.currentTimeMillis();
		
		System.out.println("It took "+( (end - start) / 1000.0 )+" seconds to compute "+( n * (n-1) / 2 )+" distances.");

		//It took 0.017 seconds to recall 435 distances.
		start = System.currentTimeMillis();
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				Location a = locations.get(i);
				Location b = locations.get(j);
				System.out.println(a+ " -> " + b + " = " + GoogleMapsUtils.getDistance(a, b) + "km");
			}
		}
		end = System.currentTimeMillis();

		System.out.println("It took "+( (end - start) / 1000.0 )+" seconds to recall "+( n * (n-1) / 2 )+" distances.");

	}
}
