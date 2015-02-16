package com.fivedirections.colormatcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TimeSelectActivity extends Activity {
	
	public static int minutes;
	
	public static final String highScore1Pref = "highScore1";
	public static final String highScore2Pref = "highScore2";
	public static final String highScore3Pref = "highScore3";
	public static final String highScore4Pref = "highScore4";
	public static final String highScore5Pref = "highScore5";
	public static final String highScore6Pref = "highScore6";
	
	TextView highScore1, highScore2, highScore3,
	         highScore4, highScore5, highScore6;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_time_select);
	    
	    highScore1 = (TextView) findViewById(R.id.highScore1);
	    highScore2 = (TextView) findViewById(R.id.highScore2);
	    highScore3 = (TextView) findViewById(R.id.highScore3);
	    highScore4 = (TextView) findViewById(R.id.highScore4);
	    highScore5 = (TextView) findViewById(R.id.highScore5);
	    highScore6 = (TextView) findViewById(R.id.highScore6);
	    checkHighScores();
	}
	
	public void timeSelectOne(View v) {
		minutes = 1;
		onClick();
	}
	
	public void timeSelectTwo(View v) {
		minutes = 2;
		onClick();
	}
	
	public void timeSelectThree(View v) {
		minutes = 3;
		onClick();
	}
	
	public void timeSelectFour(View v) {
		minutes = 4;
		onClick();
	}
	
	public void timeSelectFive(View v) {
		minutes = 5;
		onClick();
	}
	
	public void timeSelectSix(View v) {
		minutes = 6;
		onClick();
	}
	
	public void onClick() {
		Intent intent = new Intent(TimeSelectActivity.this, ColorMatcherActivity.class);
        startActivity(intent);
        this.finish();
	}
	
	public void checkHighScores() {
		SharedPreferences scoreRepository = this.getSharedPreferences("highScores", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = scoreRepository.edit();
		for (int i = 1; i <= 6; i++) {
			String s = "";
			TextView score = highScore1;
			switch (i) {
			case 1: s = highScore1Pref; score = highScore1;break;
			case 2: s = highScore2Pref; score = highScore2;break;
			case 3: s = highScore3Pref; score = highScore3;break;
			case 4: s = highScore4Pref; score = highScore4;break;
			case 5: s = highScore5Pref; score = highScore5;break;
			case 6: s = highScore6Pref; score = highScore6;break;
			}
			if(!scoreRepository.contains(s)) {
				editor.putInt(s, 0);
				editor.commit();
			}
			score.setText("" + scoreRepository.getInt(s, 0));
		}
	}

}
