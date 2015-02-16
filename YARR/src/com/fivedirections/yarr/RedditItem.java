package com.fivedirections.yarr;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.fivedirections.yarr.FlushedInputStream;

//This class is used to represent a Reddit post. It is populated with the
	// title and url while parsing each Reddit RSS post item
	class RedditItem {
		private String title;
		private String url;
		private String urlOfLink;
		private String numComments;
		private String date;
		private String urlOfMedia;
		private Bitmap media;
		
		
		public void RedditItem() {
			RedditItem("", "");
		}

		public void setDate(String date) {
			int lengthOfDate = date.length();
			this.date = date.substring(0, lengthOfDate - 6); // Trims " + 0000"
																// from time
																// stamp
		}
		
		public void makeBitmap(){
			Bitmap bitmap = null;
			try {
				bitmap = BitmapFactory
					.decodeStream(new FlushedInputStream(
							(InputStream) new URL(urlOfMedia).getContent()));
				media = bitmap;
			} catch (MalformedURLException e) {
				
			} catch (IOException e) {
				
			}
		}
		
		public Bitmap getMedia(){
			return media;
		}
		
		public void setMediaUrl (String urlOfMedia) {
			this.urlOfMedia = urlOfMedia;
		}

		public String getUrlOfMedia() {
			return urlOfMedia;
		}

		public void RedditItem(String inTitle, String inUrl) {
			title = new String(inTitle);
			url = new String(inUrl);
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUrl() {
			return url;
		}

		public String getLink() {
			return urlOfLink;
		}

		public void setNumComments(String numComments) {
			this.numComments = numComments;
		}

		public void setLink(String link) {
			urlOfLink = link;
		}

		public String getNumComments() {
			return numComments;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getSummary() {
			String summary = title + "\n" + date + "\n" + numComments
					+ "comments";
			return summary;
		}
		public String getDateAndTime() {
			String dt = date + "\n" + numComments
					+ "comments";
			return dt;
		}

		@Override
		public String toString() {

			return getTitle();
		}
	}
	
