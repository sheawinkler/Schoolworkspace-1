package com.fivedirections.colormatcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TitleScreenActivity extends Activity {
	
	ImageView newGame, quit, bgMiddle;
	public static int bgHeight, bgWidth;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		newGame = (ImageView) findViewById(R.id.newGameButton);
		quit = (ImageView) findViewById(R.id.quitButton);
		bgMiddle = (ImageView) findViewById(R.id.titleScreenMiddle);
	}
	
	public void onNewGame(View v) {
		bgHeight = bgMiddle.getHeight();
		bgWidth = bgMiddle.getWidth();
		Intent intent = new Intent(TitleScreenActivity.this, TimeSelectActivity.class);
        startActivity(intent);
	}
	
	public void onQuit(View v) {
		this.finish();
	}

}