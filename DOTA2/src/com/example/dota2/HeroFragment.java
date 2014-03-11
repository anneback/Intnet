package com.example.dota2;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HeroFragment extends ListFragment{
	private String[] heroNames;
	public HeroFragment () {
		heroNames = new String[] {
				"Abbadon",
				"Ancient apparation",
				"Bristleback",
				"Dragonknight",
				"Drow Ranger",
				"Kunkka",
				"Mirana",
				"Rubick",
				"Terrorblade",
				"Visage",
				"Witch doctor"
		};  
	}
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, heroNames);
		setListAdapter(listAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list_fragment, container, false);
	}

	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {

		Toast.makeText(getActivity(), "Purchased: "+getListView().getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
	}
}
