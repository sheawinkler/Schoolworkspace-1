package jpf.android.diary;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;

public class DiaryTest extends  ActivityInstrumentationTestCase2<Diary>{


    private Solo solo;


    public DiaryTest(){
        super(Diary.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());

    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testOnCreate() throws Exception {
        solo.assertCurrentActivity("wrong activity", Diary.class);

        solo.pressMenuItem(0);

    }

    public void testOnSaveInstanceState() throws Exception {

    }

    public void testOnPause() throws Exception {

    }

    public void testOnResume() throws Exception {

    }
}