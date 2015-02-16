package com.fivedirections.colormatcher;

import android.content.Context;
import android.widget.ImageView;

public class TileView extends ImageView{

	public TileView(Context context) {
		super(context);
	}
	
	public void setImageResource(int resId) {
		super.setImageResource(resId);
		setTag(resId);
	}

}
