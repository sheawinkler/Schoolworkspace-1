package jpf.android.diary.test;


import org.junit.Test;

import com.robotium.solo.Solo;

import jpf.android.diary.Diary;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

public class InitialTest extends ActivityInstrumentationTestCase2<Diary> {
	   private Solo solo;
		public InitialTest(){
		super("jpf.android.diary", Diary.class);
			//super(Diary.class);
		}
		
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	
	}
	
	    @Test
	    public void testdataRace() {
		 	//Below is a test that will create a data race to upload the entry
		 
		 
	        //solo.assertCurrentActivity("check on firs activity", Diary.class);    
	        //solo.clickOnButton();
	        //solo.pressMenuItem(R.id.copyleft);
	        //solo.waitForActivity("Main Activity");
	        solo.sleep(1000);
	        //solo.typeText(android.widget.EditText editText, "i am testing");
	        //solo.pressMenuItem(0);
	        solo.pressMenuItem(0);
	        solo.pressMenuItem(2);
	        
	        solo.clearEditText(0);
	        solo.enterText(0, "\n I am testing");
	        solo.enterText(0, "\n I am going to sleep for 3 seconds");
	        solo.sleep(3000); //milliseconds
	        solo.enterText(0, "\n I am awake");
	        //solo.waitForActivity("Main Activity");
	        solo.sleep(2000);
	        
	        solo.clearEditText(0);
	        solo.enterText(0, "Lets try to press buttons");
	        
	        solo.sleep(2000);
	        
	        solo.pressMenuItem(0);
	        solo.pressMenuItem(2);
	        solo.pressMenuItem(0);
	        solo.pressMenuItem(2);
	        
	        solo.clearEditText(0);
	        solo.enterText(0, "\n I am today");
	        //solo.waitForActivity("Main Activity");
	        solo.sleep(2000);
	        solo.clearEditText(0);
	        solo.enterText(0, " I am going to demonstrate the data race now");
	        solo.sleep(1000);
	        

	        Log.d("TAG", "DATA RACE : " + "pressed ");
	        
	        //solo.pressMenuItem(0);
	        //solo.pressMenuItem(2); //today
	        solo.enterText(0, " bla bla bla");
	        solo.pressMenuItem(0); //previous
	        solo.pressMenuItem(4);  // encrypt
	        //solo.sleep(1000);
	        solo.pressMenuItem(5);  // copy left
	        //solo.pressMenuItem()
	        solo.sleep(3000);
	        
	        //solo.assertCurrentActivity(message, activityClass)
	        /*
	        solo.assertCurrentActivity("check on firs activity", Diary.class);
	        solo.pressMenuItem(2);
	        solo.clearEditText(0);
	        solo.enterText(0, "No data race this time");
	        solo.sleep(1000);
	        solo.pressMenuItem(2);
	        solo.pressMenuItem(0);
	        solo.sleep(5000);
	        solo.pressMenuItem(4);
	        solo.sleep(2000);
	        solo.pressMenuItem(5);
	        */
	    //    fail("Not yet implemeted");
	        
	        
	        //Below is a test that will not create a data race
	        
	        /* solo.sleep(5000);
             solo.goBack();
             solo.pressMenuItem(2);
             solo.clearEditText(0);
             solo.enterText(0, "No data race demonstration");
             solo.sleep(2000);
             solo.pressMenuItem(0);
             solo.pressMenuItem(4);
             solo.sleep(3000);
             solo.pressMenuItem(5);
             */
	    }
	 
	
	 
}
