package neutronwombat.injectionprototype;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewContactsActivity extends ListActivity {

    private ArrayAdapter<PrivateContact> c_adapter = null;
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
        setContentView(R.layout.activity_view_contacts);
        db = new MySQLiteHelper(this);
        Log.d("DEBUG", "OnCreate in ViewContactsActivity");
        initList();
    }

    private void initList(){

        ArrayList<PrivateContact> list = (ArrayList<PrivateContact>) db.getAllContacts(username);
        c_adapter = new PrivateContactAdapter(this, R.layout.list_item, list);
        setListAdapter(c_adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_contacts, menu);
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


