package com.fivedirections.yarr;

//This class defines the activity of the list of comments

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.fivedirections.yarr.RedditItem;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
public class CommentActivity extends Activity {
	
	private static final String TAG = "CommentActivity";
	TextView commentDisplayView;
	ListView commentListView;
	String commentString = null;
	ArrayList<CommentItem> commentList = null;
	String uri;
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_comment);
       Intent intent = getIntent();
       uri = intent.getStringExtra(MainRedditActivity.MESSAGE);
       commentListView = (ListView) findViewById(R.id.listView1);
       refreshCommentRSS(commentListView);
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_comment, menu);
        return true;
    }

    //Initializes AsyncTask to populate commentList
    public void refreshCommentRSS(View view) {
    	// Initialize the display string (used for debug currently)
    	commentString = new String("");
    	// Initialize the arraylist used to contain all Reddit posts from the RSS feed
    	commentList = new ArrayList<CommentItem>();
    	// Launch the async task to grab the rss feed from Reddit
    	new CommentRefresher().execute(uri);
    }
    
    class CommentRefresher extends AsyncTask<String, Integer, String> {
    	// Parse the current Reddit post's RSS xml in a separate thread to avoid hanging the UI
    	@Override
 	    protected String doInBackground(String... urls) { //
 	    	try {
 	    		return refreshComments(urls[0]);
 	    	} catch (IOException e) {
 	    		Log.e(TAG, e.toString());
 	    		e.printStackTrace();
 	    		commentString += e.toString();
 	    		return e.toString();
 	    	}
 	    }
 	
 	    // Called when this async task has completed, used to display the results
    	// of parsing the RSS feed in this activity's UI.
 	    @Override
 	    protected void onPostExecute(String result) {
 	    	// Debug display of RSS post titles
 	    	//redditDisplayView.setText(redditRssString);
 	    	commentList.get(0).setTitle("Comments:");
 	    	// Create the listview adapter and populate it with the array of posts from the Reddit RSS feed
 	    	ArrayAdapter<CommentItem> adapter = new ArrayAdapter<CommentItem>(CommentActivity.this, 
 	    					android.R.layout.simple_list_item_1, commentList);    	
 	    	commentListView.setAdapter(adapter);
 	    }
    
    	// Setup an XML SAX parser to parse the XML RSS feed from Reddit
	    public String refreshComments(String urlString) throws IOException{
	    	CommentRSSHandler handler = new CommentRSSHandler();
	    	try {
	    		URL url = new URL(urlString);
	    		SAXParserFactory spf = SAXParserFactory.newInstance();
	    		SAXParser sp = spf.newSAXParser();
	    		XMLReader xr = sp.getXMLReader();
	    		
	    		// Set our content handler used to respond to SAX callouts, and parse the XML
	    		xr.setContentHandler(handler);
	    		xr.parse(new InputSource(url.openStream()));
	    		
	    	} catch (Exception e) {
	    		Log.e(TAG,e.toString());
	    		commentString = e.toString();
	    	}
	    	return commentString;
	    }
    }
    

    // This class is the XML SAX handler used to respond to SAX callouts while parsing Reddit's RSS feed
    class CommentRSSHandler extends DefaultHandler {
    	StringBuffer charBuffer = null;
		CommentItem currentItem = null;
		boolean inItem = false;
		
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes atts) {
			charBuffer = new StringBuffer();
			// Only store titles and urls that are enclosed in an 'item' tag
			// (ie. posts on Reddit)
			if (localName.equalsIgnoreCase("item")) {
				inItem = true;
			} else if (localName.equalsIgnoreCase("description")) {

				// Instantiate the new RedditItem that will be populated with
				// data once we are finished parsing this element.
				currentItem = new CommentItem();
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			
			if (localName.equalsIgnoreCase("item")){
				// Once the item element ends, stop storing posts until a new
				// item begins
				inItem = false;
			} else if (localName.equalsIgnoreCase("description")) {

				// Store the charbuffer we have been building up while parsing
				// this title element
				charBuffer.append('\n');
				commentString += charBuffer;
				currentItem.setTitle(charBuffer.toString());
				
				// Only add the item to the listview if it is contained in an
				// "item" RSS element
				if (inItem) {
					commentList.add(currentItem);
					
				}else if(localName.equalsIgnoreCase("link")) {
	    			
	    			// Store the url that we have been parsing in this link element
	    			currentItem.setUrl(charBuffer.toString());
	    		}
			} 
		}
		
    	@Override
    	public void characters(char ch[], int start, int length) {
    		
    		// Store all characters found while parsing the current element
    		charBuffer.append(ch,start,length);
    	}

    }
    
    
    
    
    // This class is used to represent a comment.  It is populated with the title and url while parsing each Reddit RSS post item
   private class CommentItem {
    	private String title;
    	private String url;
    	
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return getTitle();
		}
    }
}
