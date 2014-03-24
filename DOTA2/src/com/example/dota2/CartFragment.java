package com.example.dota2;

import java.util.ArrayList;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Class that contains some core logic behind the showing and workings of the cart application (showing price and buy button)
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
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
		final ArrayList<Item> cart_items = cm.get_shopping_cart_information(sc_id);
		CartListAdapter adapter= null;
		if(sc_id!=-1){
			adapter = new CartListAdapter(getActivity(),cart_items);
			listView.setAdapter(adapter);
			TextView allInAllTotal = (TextView) view.findViewById(R.id.textView1);
			Button buyButton = (Button) view.findViewById(R.id.cartbutton);
			final int price= cm.get_total_price();
			allInAllTotal.setText("Total amount to pay: "+String.valueOf(price));
			buyButton.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View v) {
					final Dialog dialog = new Dialog(getActivity());
					dialog.setContentView(R.layout.receipt);
					dialog.setTitle("Receipt");
					ImageView image = (ImageView) dialog.findViewById(R.id.receipt_image);
					image.setImageResource(R.drawable.secret_shop);
					TextView text = (TextView) dialog.findViewById(R.id.receipt_text);
					text.setText("You bought: "+cart_items.size()+" items for "+price);
					
					Button dialogOkButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
					Button dialogCancelButton = (Button) dialog.findViewById(R.id.dialogButtonCancel);
					// if button is clicked, close the custom dialog
					dialogCancelButton.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
					});
					
					dialogOkButton.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog.dismiss();
							
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
							transaction.commit();
						}
					});
					dialog.show();
				}

			});
		}
		return view;
	}



}
