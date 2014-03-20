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
	    ItemModel im = new ItemModel();
	    Bundle bundle = this.getArguments();
	    String h_id=null;
	    if(bundle!=null){
	    	  h_id = bundle.getString("h_id");
	    }
		ArrayList<Item> temp=null;
		if(h_id!=null){
			temp = im.get_item_by_hero(h_id);
		}else{
		    temp = im.get_all_items();
		}
	    View v = inflater.inflate(R.layout.tabfragment, null);
	    GridView gridView = (GridView) v.findViewById(R.id.grid_of_fragments);
	    Item[] items = new Item[temp.size()];
	    for(int i = 0; i < items.length; i++) {
	    	items[i] = temp.get(i);
	    }
	    gridView.setAdapter(new ItemAdapter(getActivity(), items));

	    return v;
	}
}
