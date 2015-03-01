package neutronwombat.injectionprototype;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddContactActivity extends ActionBarActivity {

    private EditText nameET = null;
    private EditText phoneNumberET = null;
    private EditText emailET = null;
    private EditText addressET = null;
    private MySQLiteHelper db = null;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            username = extras.getString("USERNAME");
        }

        setContentView(R.layout.activity_add_contact);
        initInterface();
        //Log.d("DEBUG", "Got here");
        db = new MySQLiteHelper(this);
    }

    private void initInterface(){
        nameET = (EditText) findViewById(R.id.nameET);
        phoneNumberET = (EditText) findViewById(R.id.phoneNumberET);
        emailET = (EditText) findViewById(R.id.emailET);
        addressET = (EditText) findViewById(R.id.addressET);
    }

    public void addContactToDB(View view){
        Log.d("DEBUG", "is running!");
        String owner = username;
        String name = nameET.getText().toString();
        String phoneNumber = phoneNumberET.getText().toString();
        String email = emailET.getText().toString();
        String address = addressET.getText().toString();

        PrivateContact privateContact = new PrivateContact(owner, name, phoneNumber, email, address);
        db.addContact(privateContact);
        Toast.makeText(getApplicationContext(), "Contact Added", Toast.LENGTH_SHORT);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
        return true;
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
