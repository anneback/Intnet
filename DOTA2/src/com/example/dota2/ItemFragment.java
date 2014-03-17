package com.example.dota2;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class ItemFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
		
	    View v = inflater.inflate(R.layout.tabfragment, null);
	    GridView gridView = (GridView) v.findViewById(R.id.grid_of_fragments);
	    ItemModel im = new ItemModel();
	    ArrayList<Item> temp = im.get_all_items(); 
	    Item[] items = new Item[temp.size()];
	    for(int i = 0; i < items.length; i++) {
	    	items[i] = temp.get(i);
	    }
	    
	    gridView.setAdapter(new ImageAdapter(getActivity(), items));

	    return v;
	}
}
