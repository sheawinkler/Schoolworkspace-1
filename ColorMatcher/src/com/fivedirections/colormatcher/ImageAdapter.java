package com.fivedirections.colormatcher;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}
	
	public int maxPosition = -1; 

	static Integer[] tiles = {R.drawable.red_tile, R.drawable.orange_tile,
			R.drawable.yellow_tile, R.drawable.green_tile,
			R.drawable.blue_tile, R.drawable.purple_tile,
			R.drawable.red_tile_selected, R.drawable.orange_tile_selected,
			R.drawable.yellow_tile_selected, R.drawable.green_tile_selected,
			R.drawable.blue_tile_selected, R.drawable.purple_tile_selected};

	// create a new TileView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		TileView imageView;
		if (convertView == null) { // if it's not recycled, initialize some attributes
			imageView = new TileView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(54, 54));
			imageView.setScaleType(TileView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
			imageView.setId(position);
		} else {
			imageView = (TileView) convertView;
		}
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}
	
	public void initRandom() {
		for(int i = 0; i < ColorMatcherActivity.gridSize; i++) {
			mThumbIds[i] = tiles[(int) (Math.random()*6)];
		}
	}

	// references to our images
	Integer[] mThumbIds = { tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9], tiles[4], tiles[10],
			tiles[5], tiles[11], tiles[0], tiles[6], tiles[1], tiles[7],
			tiles[2], tiles[8], tiles[3], tiles[9]};
	
	public void setNumTiles(int tileNum) {
		mThumbIds = new Integer[tileNum];
		for (int i = 0; i < tileNum; i++) {
			mThumbIds[i] = tiles[i%12];
		}
	}
	
}