package com.example.dota2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class CartFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
   	 View view =  inflater.inflate(R.layout.activity_cart, container, false);
   	CartModel cm= new CartModel();
	SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.getActivity().getBaseContext());
	Integer sc_id= preferences.getInt("sc_id", -1);
	ItemListAdapter adapter= null;
	if(sc_id!=-1){
		adapter = new ItemListAdapter(view.getContext(), cm.get_shopping_cart_information(sc_id));
	
	 
    // 2. Get ListView from activity_main.xml
    ListView listView = (ListView) this.getActivity().findViewById(R.id.cartlistview);

    // 3. setListAdapter
    listView.setAdapter(adapter);
    TextView allInAllTotal = (TextView) this.getActivity().findViewById(R.id.textView1);
    allInAllTotal.setText("Total amount to pay: "+String.valueOf((cm.get_total_price())));
	}
   	 return view;
	}



}