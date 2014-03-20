package com.example.dota2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CartFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.activity_cart, container, false);
		ListView listView = (ListView) view.findViewById(R.id.cartlistview);
		final CartModel cm= new CartModel();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.getActivity().getBaseContext());
		final Integer sc_id= preferences.getInt("sc_id", -1);
		final Integer u_id= preferences.getInt("user_id", -1);
		CartListAdapter adapter= null;
		

		if(sc_id!=-1){
			adapter = new CartListAdapter(getActivity(), cm.get_shopping_cart_information(sc_id));

			// 3. setListAdapter
			listView.setAdapter(adapter);
			TextView allInAllTotal = (TextView) view.findViewById(R.id.textView1);
			Button buyButton = (Button) view.findViewById(R.id.cartbutton);
			allInAllTotal.setText("Total amount to pay: "+String.valueOf((cm.get_total_price())));
			buyButton.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View v) {
					Log.d("CARTACTIVITY","waaaaaaaaaj");
					cm.buyCart(u_id, sc_id);
					int newsc_id=cm.register_shopping_cart(u_id);
					CartFragment newFragment = new CartFragment();
					SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
					SharedPreferences.Editor editor = preferences.edit();
					editor.putInt("sc_id", newsc_id);
					editor.commit();
					FragmentTransaction transaction = getFragmentManager().beginTransaction();
					transaction.replace(android.R.id.content, newFragment);
					transaction.addToBackStack(null);
					// Commit the transaction
					transaction.commit();

				}

			});
		}
		return view;
	}



}
