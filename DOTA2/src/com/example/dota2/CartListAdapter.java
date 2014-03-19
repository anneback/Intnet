package com.example.dota2;


import java.util.ArrayList;

import com.example.dota2.ItemAdapter.ItemOnClickListener;
 
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
 
public class CartListAdapter extends ArrayAdapter<Item> {
	private CartModel cart;
        private final Context context;
        private final ArrayList<Item> itemsArrayList;
        private Integer sc_id;
 
        public CartListAdapter(Context context, ArrayList<Item> itemsArrayList) {
            super(context, R.layout.itemrow, itemsArrayList);
            this.cart = new CartModel();
            this.context = context;
            this.itemsArrayList = itemsArrayList;
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences((Activity) context);
    		sc_id = pref.getInt("sc_id", -1);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 1. Create inflater
            LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 2. Get rowView from inflater
            View rowView = inflater.inflate(R.layout.itemrow, parent, false);
            // 3. Get the two text view from the rowView
            TextView labelView = (TextView) rowView.findViewById(R.id.label);
            TextView valueView = (TextView) rowView.findViewById(R.id.value);
            TextView quantityView = (TextView) rowView.findViewById(R.id.quantity);
            TextView itemTotalView = (TextView) rowView.findViewById(R.id.item_total);
            Button addToCart = (Button) rowView.findViewById(R.id.remove_from_cart);
            // 4. Set the text for textView
            labelView.setText("Item name: "+itemsArrayList.get(position).get_value("p_label"));
            valueView.setText("Item price: "+itemsArrayList.get(position).get_value("p_price"));
            quantityView.setText("Item quantity: "+itemsArrayList.get(position).get_value("quantity"));
            itemTotalView.setText("Totalling: "+itemsArrayList.get(position).get_value("totalprice"));
            addToCart.setOnClickListener(new ItemOnClickListener(cart,itemsArrayList.get(position).get_value("p_id"), sc_id));
         
 
            // 5. retrn rowView
            return rowView;
        }
        
        public class ItemOnClickListener implements OnClickListener{
    		CartModel cm;
    		String p_id;
    		Integer sc_id;
    		
    		
    		public ItemOnClickListener (CartModel cm, String pid, Integer scid) {
    			this.p_id = pid;
    			this.sc_id = scid;
    			this.cm = cm;
    		}
    		@Override
    		public void onClick(View v) {
    			cm.remove_item_from_cart(p_id, sc_id);
    			CartFragment newFragment = new CartFragment();
    			
    			FragmentTransaction transaction = ((Activity)context).getFragmentManager().beginTransaction();
    			transaction.replace(android.R.id.content, newFragment);
    			transaction.addToBackStack(null);
    			// Commit the transaction
    			transaction.commit();
    		}
    	}
}