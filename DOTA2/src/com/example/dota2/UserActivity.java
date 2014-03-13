package com.example.dota2;

import java.util.ArrayList;
import java.util.List;

import com.example.dota2.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class UserActivity extends FragmentActivity implements TabListener{

	private final String[] TAB_TEXTS = {
			"Items",
			"Heroes",
			"Misc"};

	List<Fragment> fragList = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
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

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment f = null;
		TabFragment tf = null;

		if (fragList.size() > tab.getPosition()) {
			fragList.get(tab.getPosition());
		}
		
		if (f == null) {
			tf = new TabFragment();
			Bundle data = new Bundle();
			data.putInt("idx",  tab.getPosition());
			tf.setArguments(data);
			fragList.add(tf);
		} else {
			tf = (TabFragment) f;
		}
		ft.replace(android.R.id.content, tf);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (fragList.size() > tab.getPosition()) {
			ft.remove(fragList.get(tab.getPosition()));
		}

	}

	/*
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Log.d("SimpleActionBarTabsActivity","tab "
				+ String.valueOf(tab.getPosition()) + " re-clicked");	
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		int selectedTab = tab.getPosition();
		if(selectedTab == 0) {
			ItemFragment itemsTab = new ItemFragment();
			getSupportFragmentManager().beginTransaction().replace(android.R.id.content, itemsTab).commit();
		} else if(selectedTab == 1) {
			HeroFragment heroesTab = new HeroFragment();
			getSupportFragmentManager().beginTransaction().replace(android.R.id.content, heroesTab).commit();
		} else if (selectedTab == 2) {
			//MiscFragment miscTab = new MiscFragment();
			//getSupportFragmentManager().beginTransaction().replace(R.id.user_container, miscTab).commit();
		}

		Log.d("SimpleActionBarTabsActivity","tab "
				+ String.valueOf(tab.getPosition()) + " clicked");
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		Log.d("SimpleActionBarTabsActivity","tab "
				+ String.valueOf(tab.getPosition()) + " un-clicked");	
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_settings:
			//if pressed Logout in settings button go back to main
			startActivity(new Intent(this, MainActivity.class));
		default:
			return super.onOptionsItemSelected(item);
		}
	}*/
}