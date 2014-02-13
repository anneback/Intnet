package com.example.dota2;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class UserActivity extends FragmentActivity implements ActionBar.TabListener{
	private final String[] TAB_TEXTS = {"Items","Heroes","Keys"};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        
        ActionBar menu = getActionBar(); 
        // a bar with tabs
        menu.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //don't want to have the option of "going back"
        //because of security reasons
        menu.setDisplayHomeAsUpEnabled(false);
        
        for (int i = 0; i < TAB_TEXTS.length; i++) {
        	Tab tab = menu.newTab();
        	tab.setText(TAB_TEXTS[i]);
        	tab.setTabListener(this);
        	menu.addTab(tab);
		}
    }
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Log.d("SimpleActionBarTabsActivity","tab " 
                + String.valueOf(tab.getPosition()) + " re-clicked");		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Log.d("SimpleActionBarTabsActivity","tab " 
                + String.valueOf(tab.getPosition()) + " clicked");		
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		Log.d("SimpleActionBarTabsActivity","tab " 
                + String.valueOf(tab.getPosition()) + " un-clicked");		
	}
}
