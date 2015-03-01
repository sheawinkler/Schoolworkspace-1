package bander.notepad;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.view.Menu;

public class Login extends Activity{
	
	private EditText username = null;
	private EditText password = null;
	private TextView attempts;
	private Button login;
	int counter = 3;
	public final static String USER ="USER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			setContentView(R.layout.login);
			username = (EditText)findViewById(R.id.editText1);
			password = (EditText)findViewById(R.id.editText2);
			attempts = (TextView)findViewById(R.id.textView5);
			attempts.setText(Integer.toString(counter));
			login = (Button)findViewById(R.id.button1);
	}
	
	public void login(View view){
		if(authenticateUser(username.getText().toString(), password.getText().toString())){
			Toast.makeText(getApplicationContext(), "Redirecting....", Toast.LENGTH_SHORT).show();
			//setContentView(R.layout.list);
			Intent intent = new Intent(this, NoteList.class);
			intent.putExtra(USER, username.getText().toString());
			startActivity(intent);
		}
		else{
			Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
			attempts.setBackgroundColor(Color.RED);
			counter--;
			attempts.setText(Integer.toString(counter));
			if(counter == 0){
				login.setEnabled(false);
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		//getMenuInflater().inflate(R.layout.login, menu);
		//getMenuInflater().inflate(, menu);
		return true;
	}
	
	public boolean authenticateUser(String username, String password){
		return true;
	}


}
