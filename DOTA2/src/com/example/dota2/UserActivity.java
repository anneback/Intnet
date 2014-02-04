package com.example.dota2;

import android.os.Bundle;
import android.view.Menu;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class UserActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		
		 TabHost tabHost = getTabHost();
         
	        // Tab for Items
	        TabSpec itemSpec = tabHost.newTabSpec("Items");
	        // setting Title and Icon for the Tab
	        itemSpec.setIndicator("Photos", getResources().getDrawable(R.drawable.icon_items_tab));
	        Intent photosIntent = new Intent(this, ItemsActivity.class);
	        itemSpec.setContent(photosIntent);
	         
	        // Tab for Heroes
	        TabSpec heroSpec = tabHost.newTabSpec("Heroes");
	        heroSpec.setIndicator("Videos", getResources().getDrawable(R.drawable.icon_heroes_tab));
	        Intent videosIntent = new Intent(this, HeroesActivity.class);
	        heroSpec.setContent(videosIntent);
	         
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(itemSpec); // Adding Items tab
	        tabHost.addTab(heroSpec); // Adding Heroes tab
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user, menu);
		return true;
	}

}
