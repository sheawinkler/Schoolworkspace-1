package unl.cse.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import unl.cse.utils.Pair;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GoogleMapsUtils {

	public static final String GM_GEOCODE_URL = "http://maps.googleapis.com/maps/api/geocode/json";
	public static final String GM_DISTANCE_URL = "http://maps.googleapis.com/maps/api/distancematrix/json";
	
	private static final Cache<Pair<Location, Location>, Double> DISTANCE_CACHE = new Cache<Pair<Location, Location>, Double>();

	public static Double getDistance(Location a, Location b) {
		
		Pair<Location, Location> p = Pair.make(a, b);
		Double distance = DISTANCE_CACHE.get(p);
		if(distance == null) {
			distance = getGoogleMapsDistance(a, b);
			DISTANCE_CACHE.put(p, distance);
		}
		return distance;
		
	}
	
	private static Double getGoogleMapsDistance(Location a, Location b) {
		
		String encodedOrig = null;
		String encodedDest = null;
		Double dist = null;

		try {
			encodedOrig = URLEncoder.encode(a.toString(), "UTF-8");
			encodedDest = URLEncoder.encode(b.toString(), "UTF-8");
			String url = GM_DISTANCE_URL+"?"+"origins="+encodedOrig+"&"+"destinations="+encodedDest+"&sensor=false";
			//System.out.println(url);
		
			BufferedReader in = null;

			URL gMaps = new URL(url);
			URLConnection conn = gMaps.openConnection();
	        in = new BufferedReader(new InputStreamReader(
	                conn.getInputStream()));

	        StringBuilder sb = new StringBuilder();
	        String thisLine = null;
	        while ((thisLine = in.readLine()) != null) {
	        	sb.append(thisLine);
	        }
	        String json = sb.toString();
	        
	        dist = parseJson(json);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
		
		return dist;
	}
	
	private static Double parseJson(String json) {

		Double dist = null;
		try {
			JsonParser jp = new JsonParser();
			JsonObject root = jp.parse(json).getAsJsonObject();
			JsonArray rows = root.getAsJsonArray("rows");
			JsonArray elements = rows.get(0).getAsJsonObject().getAsJsonArray("elements");
			JsonElement je = elements.get(0).getAsJsonObject().get("distance");
			JsonElement value = je.getAsJsonObject().get("value");
			String rawValue = value.getAsString();
			dist = Double.parseDouble(rawValue) / 1000.0;
		} catch (Exception e) {
			System.err.println("Encountered a problem parsing json: "+json);
			e.printStackTrace();
		}
		return dist;
	}
	
}
