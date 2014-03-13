package com.example.dota2;

import android.support.v4.app.ListFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HeroFragment extends Fragment{
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.itemgridview);
        //gridView.setAdapter(new ImageAdapter(getActivity(), new ItemModel().get_all_items()));
        return view;
    }
	
/*
	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {

		Toast.makeText(getActivity(), "Purchased: "+getListView().getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
	}*/
}
