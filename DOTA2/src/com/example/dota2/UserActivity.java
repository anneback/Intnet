package com.example.dota2;

import java.util.ArrayList;
import java.util.List;

import com.example.dota2.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
/**
 * Core functionality for swapping between our Cart,Item and Hero fragments aswell as a Logout function.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class UserActivity extends FragmentActivity implements ActionBar.TabListener{

	private final String[] TAB_TEXTS = {
			"Items",
			"Heroes",
			"Cart"};


	List<Fragment> fragList = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String loggedInUser = preferences.getString("username", null);
		this.setTitle("User: "+loggedInUser);
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for (int i=0; i < 3; i++) {
			Tab tab = bar.newTab();

			tab.setText(TAB_TEXTS[i]);
			tab.setTabListener(this);
			bar.addTab(tab);


		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		if (tab.getPosition() == 1) {
			HeroFragment heroFragment = new HeroFragment();
			ft.replace(android.R.id.content, heroFragment);			
		} 
		else if (tab.getPosition() == 2) {
			CartFragment cartFragment = new CartFragment();
			ft.replace(android.R.id.content, cartFragment);
		}
		else {
			ItemFragment tabFragment = new ItemFragment();
			ft.replace(android.R.id.content, tabFragment);
		}
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		if (tab.getPosition() == 1) {
			HeroFragment heroFragment = new HeroFragment();
			ft.replace(android.R.id.content, heroFragment);			
		} 
		else if (tab.getPosition() == 2) {
			CartFragment cartFragment = new CartFragment();
			ft.replace(android.R.id.content, cartFragment);
		}
		else {
			ItemFragment tabFragment = new ItemFragment();
			ft.replace(android.R.id.content, tabFragment);
		}
	}

	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Intent i = new Intent(UserActivity.this, MainActivity.class);
	        	SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				SharedPreferences.Editor editor = preferences.edit();
				editor.putInt("user_id", -1); // reset user id to no user
				editor.putInt("sc_id", -1); // and also session id
				editor.commit();
	        	startActivity(i);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
}