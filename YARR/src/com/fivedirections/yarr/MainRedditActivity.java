package com.fivedirections.yarr;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.Location;
import android.provider.Settings;
import com.fivedirections.yarr.RedditItem;

public class MainRedditActivity extends Activity {

	private static final String TAG = "MainRedditActivity";
	public static final String MESSAGE = "com.fivedirections.yarr.MainRedditActivity.MESSAGE";
	private int id = 0;
	private String url = "http://www.reddit.com/.rss";
	TextView redditDisplayView;
	ListView redditListView;
	String redditRssString = null;
	Address address;
	LocationManager locManager;
	ArrayList<RedditItem> itemList = null;

	// Initial entry point for this activity, used to grab references to UI
	// elements and set event listeners
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_reddit);
	

		Intent intent = this.getIntent();
		if (intent != null && intent.getExtras() != null) {
			Bundle bundle = intent.getExtras();
			String country = bundle.getString("COUNTRY");
			String state = bundle.getString("STATE");
			String city = bundle.getString("CITY");
			if (city != null) {
				url = "http://www.reddit.com/r/" + city + ".rss";

				Log.e("CITY: ", city);
				try {
					refreshRedditRSS(redditListView);
				} catch (Exception e) {
					Log.e(TAG, "Fail!");

				}
			}else if (state != null){
				url = "http://www.reddit.com/r/" + state  + ".rss";

				Log.e("STATE: ", state);
				try {
					refreshRedditRSS(redditListView);
				} catch (Exception e) {
					Log.e(TAG, "Fail!");

				}
				
			}else{
				url = "http://www.reddit.com/r/" + country  + ".rss";

				Log.e("COUNTRY: ", country);
				try {
					refreshRedditRSS(redditListView);
				} catch (Exception e) {
					Log.e(TAG, "Fail!");

				}

			}
		}

		refreshRedditRSS(redditListView);
		redditListView = (ListView) findViewById(R.id.redditListView);

	}

	public void launchGPSActivity(View view) {
		GPSTracker gpsTracker = new GPSTracker(this);
		Log.e("GPS: ", "" +gpsTracker.getLongitude());
		try {
			Address currentAddress = gpsTracker.getAddress().get(0);
			String country = currentAddress.getCountryName();
			country = country.toLowerCase();
			country = country.replaceAll("\\s","");
			
			String state = currentAddress.getAdminArea();
			state = state.toLowerCase();
			state = state.replaceAll("\\s","");
			
			String city = currentAddress.getLocality();
			city = city.toLowerCase();
			city = city.replaceAll("\\s","");
			
		
			Bundle bundle = new Bundle();
			bundle.putString("COUNTRY", country);
			bundle.putString("STATE", state);
			bundle.putString("CITY", city);
			
			Intent gpsLauncher = new Intent(this, MainRedditActivity.class);
			gpsLauncher.putExtras(bundle);
		
			startActivity(gpsLauncher);
			
		
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
			Log.e(TAG, "IO Error");
		}

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_reddit, menu);
		return true;
	}

	public void refreshRedditRSS(View view) {
		// Initialize the display string (used for debug currently)
		redditRssString = new String("");

		// Initialize the arraylist used to contain all Reddit posts from the
		// RSS feed
		itemList = new ArrayList<RedditItem>();
		// Launch the async task to grab the rss feed from Reddit
		new RefreshTask().execute(url);
	}

	// This class is the XML SAX handler used to respond to SAX callouts while
	// parsing Reddit's RSS feed
	class RSSHandler extends DefaultHandler {
		StringBuffer charBuffer = null;
		RedditItem currentItem = null;
		boolean inItem = false;

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes atts) {
			charBuffer = new StringBuffer();
			// Log.e("LOCAL NAME:", localName);
			// Log.e("Q NAME: ", qName);
			// Only store titles and urls that are enclosed in an 'item' tag
			// (ie. posts on Reddit)
			if (localName.equalsIgnoreCase("item")) {
				inItem = true;
			} else if (localName.equalsIgnoreCase("title") && // The Reddit rss
					// provides
					// media titles
					// with images,
					// don't want to
					// include those
					// yet
					!qName.equalsIgnoreCase("media:title")) {

				// Instantiate the new RedditItem that will be populated with
				// data once we are finished parsing this element.
				currentItem = new RedditItem();
			} else if (qName.equalsIgnoreCase("media:thumbnail")) {

				String attrValue = atts.getValue("url");
				// Log.e("MEDIA: ", attrValue);
				currentItem.setMediaUrl(attrValue);
				currentItem.makeBitmap();

			}

		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {

			if (localName.equalsIgnoreCase("item")) {
				// Once the item element ends, stop storing posts until a new
				// item begins
				inItem = false;
			} else if (localName.equalsIgnoreCase("title")
					&& !qName.equalsIgnoreCase("media:title")) {

				// Store the charbuffer we have been building up while parsing
				// this title element
				charBuffer.append('\n');
				redditRssString += charBuffer;
				currentItem.setTitle(charBuffer.toString());

				// Only add the item to the listview if it is contained in an
				// "item" RSS element
				if (inItem) {

					itemList.add(currentItem);
				}

			} else if (localName.equalsIgnoreCase("link")) {

				// Store the url that we have been parsing in this link element
				currentItem.setUrl(charBuffer.toString());

			} else if (localName.equalsIgnoreCase("description")) {
				String buffer = charBuffer.toString();
				try {

					String links[] = buffer.split("href");

					if (links[3].contains("reddit")) {
						currentItem.setLink(links[4].substring(2,
								links[4].indexOf(">") - 1));
					} else {
						currentItem.setLink(links[3].substring(2,
								links[3].indexOf(">") - 1));
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					Log.e(TAG, "Finished Parsing Information");
				}

				try {
					String comments[] = buffer.split("comments]");

					String numComments = comments[0].substring(comments[0]
							.lastIndexOf("[") + 1);
					currentItem.setNumComments(numComments);

				} catch (StringIndexOutOfBoundsException e) {
					Log.e(TAG, "No Comments In This Item.");
				}

			} else if (localName.equalsIgnoreCase("pubDate")) {
				currentItem.setDate(charBuffer.toString());
			}
		}

		@Override
		public void characters(char ch[], int start, int length) {
			// Store all characters found while parsing the current element
			charBuffer.append(ch, start, length);
		}
	}

	class RefreshTask extends AsyncTask<String, Integer, String> {

		// Parse the Reddit RSS xml in a separate thread to avoid hanging the UI
		@Override
		protected String doInBackground(String... urls) { //
			try {
				return refreshReddit(urls[0]);
			} catch (IOException e) {
				Log.e(TAG, e.toString());
				e.printStackTrace();
				redditRssString += e.toString();
				// itemList.add(e.toString());
				return e.toString();
			}
		}

		// Called when this async task has completed, used to display the
		// results
		// of parsing the RSS feed in this activity's UI.
		@Override
		protected void onPostExecute(String result) {
			// Debug display of RSS post titles
			// redditDisplayView.setText(redditRssString);

			// Create the listview adapter and populate it with the array of
			// posts from the Reddit RSS feed

			MyAdapter<RedditItem> adapter = new MyAdapter<RedditItem>(
					MainRedditActivity.this,
					android.R.layout.simple_list_item_1, itemList);
			redditListView.setAdapter(adapter);
		}

		// Setup an XML SAX parser to parse the XML RSS feed from Reddit
		public String refreshReddit(String urlString) throws IOException {
			RSSHandler df = new RSSHandler();
			try {
				URL url = new URL(urlString);
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				XMLReader xr = sp.getXMLReader();

				// Set our content handler used to respond to SAX callouts, and
				// parse the XML
				xr.setContentHandler(df);
				xr.parse(new InputSource(url.openStream()));
			} catch (Exception e) {
				Log.e(TAG, e.toString());
				redditRssString = e.toString();
			}

			return redditRssString;
		}

		// MyAdapter class overrides getView(int, View, ViewGroup) so that each
		// item in list
		// contains a text view of the title in addition to a link button for
		// the actual Reddit link
		// The layout of the list item is defined in
		// res/layout/adapter_component.xml
		class MyAdapter<RedditItem> extends ArrayAdapter {
			public MyAdapter(Context context, int textViewResourceId,
					List<RedditItem> objects) {
				super(context, textViewResourceId, objects);
			}

			// Returns a view containing title link to comments and button link
			// to website
			public View getView(int idx, View currentView, ViewGroup viewGroup) {
				View mainItemViewContainer = new View(super.getContext());
				View view = currentView;
				if (view == null) {
					LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					view = inflater.inflate(R.layout.adapter_component, null);
				}
				RedditItem item = (RedditItem) super.getItem(idx);
				String title = ((com.fivedirections.yarr.RedditItem) item)
						.getTitle();
				String dateAndTimeString = ((com.fivedirections.yarr.RedditItem) item)
						.getDateAndTime();
				if (item != null) {
					TextView postTitle = (TextView) view
							.findViewById(R.id.titleName);
					ImageView thumbnailView = (ImageView) view
							.findViewById(R.id.thumbnail);

					TextView linkToSite = (TextView) view
							.findViewById(R.id.link);
					TextView dateTime = (TextView) view
							.findViewById(R.id.metaData);
					dateTime.setText(dateAndTimeString);
					// Url for the COMMENTS of the Reddit post
					Uri urlOfCurrentItem = Uri
							.parse(((com.fivedirections.yarr.RedditItem) item)
									.getUrl());
					// Url for the link the person was posting
					Uri urlOfLink = Uri
							.parse(((com.fivedirections.yarr.RedditItem) item)
									.getLink());

					thumbnailView
					.setImageBitmap(((com.fivedirections.yarr.RedditItem) item)
							.getMedia());

					if (postTitle != null) {

						postTitle.setText(title);
						// Listener for clicking on title
						postTitle.setOnClickListener(new MyPostListener(super
								.getContext(), urlOfCurrentItem));
						dateTime.setOnClickListener(new MyPostListener(super
								.getContext(), urlOfCurrentItem));
					}
					if (linkToSite != null) {

						// Listener for clicking on link button
						linkToSite.setOnClickListener(new MyLinkListener(super
								.getContext(), urlOfLink));
						thumbnailView.setOnClickListener(new MyLinkListener(
								super.getContext(), urlOfLink));
					}

				}
				return view;
			}

			// Defines listener for clicking on link button
			class MyLinkListener implements View.OnClickListener {
				private Uri address;
				private Context context;

				public MyLinkListener(Context context, Uri address) {
					this.context = context;
					this.address = address;
				}

				public void onClick(View v) {
					Intent launchBrowser = new Intent(Intent.ACTION_VIEW,
							address);
					startActivity(launchBrowser);
				}

			}

			// Defines listener for clicking on title
			class MyPostListener implements View.OnClickListener {
				private Uri address;
				private Context context;

				public MyPostListener(Context context, Uri address) {
					this.context = context;
					this.address = address;
				}

				public void onClick(View v) {
					Intent showComments = new Intent(context,
							CommentActivity.class);
					String uriString = address.toString() + ".rss";
					showComments.putExtra(MESSAGE, uriString);
					Log.e(TAG, uriString);
					startActivity(showComments);

				}
			}
		}
	}

}
