package com.fivedirections.colormatcher;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreDisplayActivity extends Activity {
	
	public static final String highScore1Pref = "highScore1";
	public static final String highScore2Pref = "highScore2";
	public static final String highScore3Pref = "highScore3";
	public static final String highScore4Pref = "highScore4";
	public static final String highScore5Pref = "highScore5";
	public static final String highScore6Pref = "highScore6";

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_score_display);
	    TextView finalScoreCount = (TextView) findViewById(R.id.finalScoreCount);
	    finalScoreCount.setText("" + ColorMatcherActivity.score);
	    checkHighScore();
	}
	
	public void onContinue(View v) {
		this.finish();
	}
	
	public void checkHighScore() {
		SharedPreferences scoreRepository = this.getSharedPreferences("highScores", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = scoreRepository.edit();
		String s = "";
		switch (TimeSelectActivity.minutes) {
		case 1: s = highScore1Pref;break;
		case 2: s = highScore2Pref;break;
		case 3: s = highScore3Pref;break;
		case 4: s = highScore4Pref;break;
		case 5: s = highScore5Pref;break;
		case 6: s = highScore6Pref;break;
		}
		int currentBest = scoreRepository.getInt(s, 0);
		if (ColorMatcherActivity.score > currentBest) {
			editor.putInt(s, ColorMatcherActivity.score);
			editor.commit();
			ImageView bg = (ImageView) findViewById(R.id.titleScreen);
			bg.setImageResource(R.drawable.high_score_bg);
		}
	}
	
	@Override
	public void onBackPressed() {
		//User should go forward to title screen, not back (logically, the game)
	return;
	}

}
