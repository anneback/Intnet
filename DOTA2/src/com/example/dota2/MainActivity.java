package com.example.dota2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
		

		//ImageView view = (ImageView)findViewById(R.id.main_image);

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
				//
				Context context = getApplicationContext();
			
				int duration = Toast.LENGTH_LONG;
				String text = "user_id: "+String.valueOf(preferences.getInt("user_id", 1337));
				text=text+" Sc id: "+String.valueOf(preferences.getInt("sc_id", 1337));
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				Intent i = new Intent(MainActivity.this, CartActivity.class);

				startActivity(i);
				//		setContentView(R.layout.items_layout);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

