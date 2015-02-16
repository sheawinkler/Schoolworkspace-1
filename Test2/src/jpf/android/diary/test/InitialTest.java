package jpf.android.diary.test;


import org.junit.Test;

import com.robotium.solo.Solo;

import jpf.android.diary.Diary;
import android.test.ActivityInstrumentationTestCase2;
//import android.util.Log;

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
		 
		 

	        solo.sleep(1000);
	        solo.pressMenuItem(0);
	        solo.pressMenuItem(2);
	        solo.clearEditText(0);
	        solo.enterText(0, "\n I am testing");
	        solo.enterText(0, "\n I am going to sleep for 3 seconds");
	        solo.sleep(3000); //milliseconds
	        solo.enterText(0, "\n I am awake");
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
	        solo.sleep(2000);
	        solo.clearEditText(0);
	        solo.enterText(0, " I am going to demonstrate the data race now");
	        solo.sleep(1000);
	        
	        //Use for testing to determine butting presses at this moment
	        //Log.d("TAG", "DATA RACE : " + "pressed ");
	      
	   
	        solo.enterText(0, " bla bla bla");
	        solo.pressMenuItem(0); //previous
	        solo.pressMenuItem(4);  // encrypt      
	        solo.pressMenuItem(5);  // copy left
	        solo.sleep(3000);
	        

	        //Below is a test that will not create a data race
	        
	         solo.sleep(5000);
             solo.goBack();
             solo.pressMenuItem(2);
             solo.clearEditText(0);//previous
             solo.enterText(0, "No data race demonstration");
             solo.sleep(2000);
             solo.pressMenuItem(0);
             solo.pressMenuItem(4);//encrypt
             solo.sleep(3000);
             solo.pressMenuItem(5);//copyleft
             
	    }
	 
	
	 
}
