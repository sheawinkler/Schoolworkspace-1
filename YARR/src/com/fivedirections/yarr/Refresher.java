package com.fivedirections.yarr;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.fivedirections.yarr.MainRedditActivity.RSSHandler;

import android.os.AsyncTask;
import android.util.Log;

public abstract class Refresher extends AsyncTask<String, Integer, String> {
	private String url;
	private DefaultHandler handler;
	private String currentString;

	public Refresher(String url, DefaultHandler handler) {
		this.url = url;
		this.currentString = "";
		this.handler = handler;
	}

	// Parse the Reddit RSS xml in a separate thread to avoid hanging the UI
	@Override
	protected String doInBackground(String... urls) { //
		try {
			return refresh(urls[0]);
		} catch (IOException e) {

			e.printStackTrace();
			currentString += e.toString();
			// itemList.add(e.toString());
			return e.toString();
		}
	}

	protected abstract void onPostExecute(String result);

	public String refresh(String urlString) throws IOException {
		try {
			URL url = new URL(urlString);
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			// Set our content handler used to respond to SAX callouts, and
			// parse the XML
			xr.setContentHandler(handler);
			xr.parse(new InputSource(url.openStream()));
		} catch (Exception e) {

			currentString = e.toString();
		}

		return currentString;
	}

}
