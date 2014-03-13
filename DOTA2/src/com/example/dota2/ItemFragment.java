package com.example.dota2;

import com.example.dota2.R;
import android.support.v4.app.ListFragment;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemFragment extends Fragment{
	private String[] itemLabels;
	private ImageAdapter imgAdapter;

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.itemgridview);
        //gridView.setAdapter(new ImageAdapter(getActivity(), new ItemModel().get_all_items()));
        return view;
    }
	
	/*@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();

        if (activity != null) {
            // Create an instance of the custom adapter for the GridView. A static array of location data
            // is stored in the Application sub-class for this app. This data would normally come
            // from a database or a web service.
            imgAdapter = new ImageAdapter(activity);

            if (gridView != null) {
            	gridView.setAdapter(imgAdapter);
            }

            // Setup our onItemClickListener to emulate the onListItemClick() method of ListFragment.
            gridView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onGridItemClick((GridView) parent, view, position, id);
                }

            });
        }
    }
	
	 public void onGridItemClick(GridView g, View v, int position, long id) {
	        Activity activity = getActivity();
	        
	        if (activity != null) {
	            Item item = (Item) imgAdapter.getItem(position);
	            
	            // Display a simple Toast to demonstrate that the click event is working. Notice that Fragments have a
	            // getString() method just like an Activity, so that you can quickly access your localized Strings.
	            Toast.makeText(activity, getString(R.string.toast_item_click) + item.address, Toast.LENGTH_SHORT).show();
	        }
	    }/*


	/*@Override
	public void onListItemClick(ListView list, View v, int position, long id) {

		Toast.makeText(getActivity(), "Purchased: "+getListView().getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
	}*/

}
