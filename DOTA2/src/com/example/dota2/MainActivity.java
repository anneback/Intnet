package com.example.dota2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * StartView with logic behind "login/registration to our application"
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class MainActivity extends Activity {
	private EditText userMailEdit;
	private EditText userPasswordEdit;
	private UserModel UM = new UserModel();
	private CartModel CM = new CartModel();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		userMailEdit= (EditText)findViewById(R.id.email);
		userPasswordEdit= (EditText)findViewById(R.id.password);
		// Getting access to stored data from the first call to the DB
		// Functions like a cookie
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		int u_id=preferences.getInt("user_id", -1); //-1 default
		int sc_id=preferences.getInt("sc_id", -1); //-1 default
		
		// Switch the activity if we already are logged in
		if(u_id!=-1 || sc_id!=-1){
			Intent i = new Intent(MainActivity.this, UserActivity.class);
			startActivity(i);
		}
		
		final Button loginButton = (Button) findViewById(R.id.login_button);
		loginButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// register the user if it not exists
				Integer user_id=UM.register_user(userMailEdit.getText().toString(), userPasswordEdit.getText().toString());
				// set a shopping cart id, sc_id
				Integer sc_id=CM.register_shopping_cart(user_id);
				// Getting access to stored data from the first call to the DB
				// Functions like a cookie
				SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				SharedPreferences.Editor editor = preferences.edit();
				// Store the values in the "cookie" i.e. SharedPreferences
				editor.putString("username", userMailEdit.getText().toString());
				editor.putInt("user_id", user_id);
				editor.putInt("sc_id", sc_id);
				editor.commit();
				
				// Successful registration - show it as a Toast
				Context context = getApplicationContext();
				int duration = Toast.LENGTH_LONG;
				String text="Registration successful";
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				Intent i = new Intent(MainActivity.this, UserActivity.class);
				startActivity(i);
			}
		});
	}

}

