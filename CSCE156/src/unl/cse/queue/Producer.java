package unl.cse.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private final BlockingQueue<String> queue;
	private final String query;
	
	private static final String login = "bourke_chris:cse156";
	private static final String encodedLogin = "Ym91cmtlX2NocmlzOmNzZTE1Ng=="; 

	public Producer(BlockingQueue<String> q, String query) {
		this.queue = q;
		this.query = query;
	}
	
	public void run() {
		
		BufferedReader in = null;

		try {

			URL twitterStream = new URL("https://stream.twitter.com/1/statuses/sample.json");
			URLConnection conn = twitterStream.openConnection();
			conn.setRequestProperty("Authorization", "Basic " + encodedLogin);
	        in = new BufferedReader(new InputStreamReader(
	                conn.getInputStream()));

			while(true) {
				String line = in.readLine();
				//System.out.println(line);
				if(line != null) 
					queue.put(line);
				//Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("dying...");
		}
	}
	
	private String search() {
		
		BufferedReader in = null;
		StringBuilder json = new StringBuilder();
		try {
			URL twits = new URL("http://search.twitter.com/search.json?q="+URLEncoder.encode(query, "UTF-8")+"&lang=en");
			URLConnection yc = twits.openConnection();
	        in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;
	
	        while ((inputLine = in.readLine()) != null) 
	        	json.append(inputLine);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return json.toString();
    }

}
