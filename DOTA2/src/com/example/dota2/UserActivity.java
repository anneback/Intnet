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
	        itemSpec.setIndicator("Items", getResources().getDrawable(R.drawable.icon_items_tab));
	        Intent itemsIntent = new Intent().setClass(this, ItemsActivity.class);
	        itemSpec.setContent(itemsIntent);
	         
	        // Tab for Heroes
	        TabSpec heroSpec = tabHost.newTabSpec("Heroes");
	        heroSpec.setIndicator("Heroes", getResources().getDrawable(R.drawable.icon_heroes_tab));
	        Intent heroesIntent = new Intent().setClass(this, HeroesActivity.class);
	        heroSpec.setContent(heroesIntent);
	         
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(itemSpec); // Adding Items tab
	        tabHost.addTab(heroSpec); // Adding Heroes tab
	        tabHost.setCurrentTab(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user, menu);
		return true;
	}

}
