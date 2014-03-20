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
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		int u_id=preferences.getInt("user_id", -1);
		int sc_id=preferences.getInt("sc_id", -1);
		if(u_id!=-1 || sc_id!=-1){
			Intent i = new Intent(MainActivity.this, UserActivity.class);
			startActivity(i);
		}
		final Button loginButton = (Button) findViewById(R.id.login_button);
		loginButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Integer user_id=UM.register_user(userMailEdit.getText().toString(), userPasswordEdit.getText().toString());
				Integer sc_id=CM.register_shopping_cart(user_id);
				SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				SharedPreferences.Editor editor = preferences.edit();
				editor.putInt("user_id", user_id); // value to store
				editor.putInt("sc_id", sc_id);
				editor.commit();
				Context context = getApplicationContext();
				int duration = Toast.LENGTH_LONG;
				String text="Successfull registration";
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				Intent i = new Intent(MainActivity.this, UserActivity.class);
				startActivity(i);
			}
		});
	}

}

