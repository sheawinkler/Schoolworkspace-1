package neutronwombat.injectionprototype;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText userID_ET = null;
    private EditText password_ET = null;
    MySQLiteHelper db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userID_ET = (EditText) findViewById(R.id.userID_ET);
        password_ET = (EditText) findViewById(R.id.password_ET);
        db = new MySQLiteHelper(this.getApplicationContext());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void setLogInfo(View view)
    {
        switch(view.getId())
        {
            case R.id.oscarButton:
                userID_ET.setText("Oscar");
                password_ET.setText("12345");
                break;
            case R.id.jasmineButton:
                userID_ET.setText("Jasmine");
                password_ET.setText("67890");
                break;
            case R.id.heroButton:
                userID_ET.setText("Hero");
                password_ET.setText("tobe");
                break;
            case R.id.inject1Button:
                userID_ET.setText("Oscar");
                password_ET.setText("' OR 1=1 --");
                break;
            case R.id.inject2Button:
                userID_ET.setText("' OR 1=1 --");
                password_ET.setText("xxxxxx");
                break;
            }
    }

    public void onLoginClick(View view)
    {
        String username = userID_ET.getText().toString();
        String password = password_ET.getText().toString();

        if(!db.authenticate(username, password)) {
            Log.d("DEBUG", "authenticate return null");
            CharSequence c = "Invalid Login";
            Toast.makeText(getApplicationContext(), c, Toast.LENGTH_SHORT).show();
        }
        else {
            Log.d("DEBUG", "should go to select option activity");
            Intent i = new Intent(this.getApplicationContext(), SelectOptionActivity.class);
            i.putExtra("USERNAME", username);
            startActivity(i);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
