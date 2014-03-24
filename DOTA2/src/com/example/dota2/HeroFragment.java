package com.example.dota2;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
/**
 * Hero fragment that shows the gridview with our different clickable heroes, 
 * most of the functionality is implemented in the HeroAdapter.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class HeroFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.tabfragment, null);
		GridView gridView = (GridView) v.findViewById(R.id.grid_of_fragments);

		HeroModel hm = new HeroModel(this.getActivity());
		ArrayList<Hero> tmp = hm.get_all_heroes(); // fetch heroes from db
		Hero[] heroes = new Hero[tmp.size()];
		for(int i = 0; i < heroes.length; i++) {
			heroes[i] = tmp.get(i);
		}
		// Fill the grid view with the heroes_layout.xml
		gridView.setAdapter(new HeroAdapter(getActivity(), heroes));
		return v;
	}
}
