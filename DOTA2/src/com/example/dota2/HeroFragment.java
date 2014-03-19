package com.example.dota2;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class HeroFragment extends Fragment{
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
		
	    View v = inflater.inflate(R.layout.tabfragment, null);
	    GridView gridView = (GridView) v.findViewById(R.id.grid_of_fragments);
	    
	    HeroModel hm = new HeroModel(this.getActivity());
	    ArrayList<Hero> tmp = hm.get_all_heroes();
	    Hero[] heroes = new Hero[tmp.size()];
	    for(int i = 0; i < heroes.length; i++) {
	    	heroes[i] = tmp.get(i);
	    }
	    
	    
	    gridView.setAdapter(new HeroAdapter(getActivity(), heroes));

	    return v;
	}
}
