package bander.notepad;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class SelectOptionActivity extends ActionBarActivity {

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);
        if(savedInstanceState == null){
            Bundle extras = this.getIntent().getExtras();
            username = extras.getString("USERNAME");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_option, menu);
        return true;
    }

    public void onBtnClick(View v){
        Intent i;
        switch (v.getId())
        {
            case R.id.addContactButton:
                i = new Intent(getApplicationContext(), AddContactActivity.class);
                i.putExtra("USERNAME", username);
                startActivity(i);
                break;

            case R.id.viewContactsButton:
                i = new Intent(getApplicationContext(), ViewContactsActivity.class);
                i.putExtra("USERNAME", username);
                startActivity(i);
                break;
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
