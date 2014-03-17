package com.example.dota2;

import java.util.ArrayList;
import java.util.List;

import com.example.dota2.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.Menu;

public class UserActivity extends FragmentActivity implements ActionBar.TabListener{

	private final String[] TAB_TEXTS = {
			"Items",
			"Heroes",
	"Cart"};


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
		/*
		Fragment f = null;
		TabFragment tf = null;
		HeroFragment cf = null;

		if (fragList.size() > tab.getPosition()) {
			fragList.get(tab.getPosition());
		}

		if (f == null) {
			if(tab.getPosition() == 0) {
				Bundle data = new Bundle();
				data.putInt("idx",  tab.getPosition());
				tf = new TabFragment();
				tf.setArguments(data);
				fragList.add(tf);
			} else if (tab.getPosition() == 1){
				Log.d("POS 1","POS 1 ="+tab.getPosition());
				Bundle data = new Bundle();
				data.putInt("idx",  tab.getPosition());
				cf = new HeroFragment();
				cf.setArguments(data);
				fragList.add(cf);
			} else {
				tf = new TabFragment();
				Bundle data = new Bundle();
				data.putInt("idx",  tab.getPosition());
				tf.setArguments(data);
				fragList.add(tf);
			}
		} else {
			tf = (TabFragment) f;
		}
		ft.replace(android.R.id.content, tf);*/
		
		if (tab.getPosition() == 1) {
			TabFragment tabFragment = new TabFragment();
			ft.replace(android.R.id.content, tabFragment);			
			//ft.commit();
		} 
		else if (tab.getPosition() == 2) {
			//FragmentTransaction ft = getFragmentManager().beginTransaction();
			CartFragment cartFragment = new CartFragment();
			ft.replace(android.R.id.content, cartFragment);
			//ft.commit();
		}
		else {
			TabFragment heroFragment = new TabFragment();
			ft.replace(android.R.id.content, heroFragment);		
			//ft.commit();
		}
	}


	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (fragList.size() > tab.getPosition()) {
			ft.remove(fragList.get(tab.getPosition()));
		}
	}
}