package com.example.dota2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class AdminActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		// Show the Up button in the action bar.
		setupActionBar();
		Button button = (Button) findViewById(R.id.button1);
		final AdminModel AM= new AdminModel();
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Post p = new Post();
				p.setPostValue("p_label", "Shadowblade");
				p.setPostValue("p_desc", "Lothars Edge");
				p.setPostValue("p_image", "/images/shadowblade.png");
				p.setPostValue("p_hero", "Kunkka");
				p.setPostValue("p_price", "20000");
				AM.add_item(p);
				Log.d("AdminActivity","SENT ITEM TO SERVER");
			}
		});
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
