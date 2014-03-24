package com.example.dota2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.ListView;
import android.widget.TextView;

public class CartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		CartModel cm= new CartModel();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		Integer sc_id= preferences.getInt("sc_id", -1); // -1 default value
		CartListAdapter adapter= null;
		if(sc_id!=-1){
			adapter = new CartListAdapter(this, cm.get_shopping_cart_information(sc_id));
        // Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.cartlistview);
 
        // setListAdapter
        listView.setAdapter(adapter);
        // textview that display's all items in the cart
        TextView allInAllTotal = (TextView) findViewById(R.id.textView1);
        allInAllTotal.setText("Total amount to pay: "+String.valueOf((cm.get_total_price())));
		}
	}


}
