package com.fivedirections.colormatcher.test;
import android.test.ActivityInstrumentationTestCase2;

import com.fivedirections.colormatcher.ColorMatcherActivity;
import com.robotium.solo.Solo;
import android.util.Log;



public class ColorMatcherAcrivityTest extends
		ActivityInstrumentationTestCase2<ColorMatcherActivity> {

	private Solo solo;
	public ColorMatcherAcrivityTest() {
		super(ColorMatcherActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	public void mainPage(){
		solo.assertCurrentActivity("check start", ColorMatcherActivity.class);
		solo.clearEditText(0);
		
		
	}

}
