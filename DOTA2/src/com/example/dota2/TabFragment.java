package com.example.dota2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class TabFragment extends Fragment{
	
	private int index;
	
	public void onCreate(Bundle savedInstanceState) {        
	    super.onCreate(savedInstanceState);
	    Bundle data = getArguments();
	    index = data.getInt("idx");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
		
	    View v = inflater.inflate(R.layout.tabfragment, null);
	    GridView gridView = (GridView) v.findViewById(R.id.grid_of_fragments);
	    ItemModel im = new ItemModel();
	    gridView.setAdapter(new ImageAdapter(getActivity(), (Item[]) im.get_all_items().toArray() ));

	    return v;
	}
}
