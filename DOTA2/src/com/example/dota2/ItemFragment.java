package com.example.dota2;

import com.example.dota2.R;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ItemFragment extends ListFragment{
	private String[] itemLabels;

	public ItemFragment () {
		itemLabels = new String[] {
				"Shadowblade",
				"IMBA HOOK",
				"Kunkka sword",
				"Pirate hat",
				"Poke ball",
				"Orange"
		};  
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemLabels);
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
