package com.example.dota2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dota2.ImageAdapter.ItemOnClickListener;

public class HeroAdapter extends ArrayAdapter{
	private CartModel cart;
	private Context ctx;
	private Hero[] heroes;
	private Integer sc_id;
	
	public HeroAdapter(Context c, Hero[] heroes)
	{
		super(c, 0);
		ctx=c;
		this.heroes = heroes;
		this.cart = new CartModel();
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences((Activity) ctx);
		sc_id = pref.getInt("sc_id", -1);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return heroes.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 View cell = convertView;
	          if (convertView == null) {
	    	    LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
	    	    cell=inflater.inflate(R.layout.items_layout, parent, false);
	            TextView textView = (TextView) cell.findViewById(R.id.grid_item_label);
	            ImageView imageView = (ImageView) cell.findViewById(R.id.grid_item_image);
	            Button addToCart = (Button) cell.findViewById(R.id.add_to_cart);
	            textView.setText(heroes[position].get_value("h_name"));
	            imageView.setImageBitmap(heroes[position].get_image());
	          //TODO IMPLEMENT
	            addToCart.setOnClickListener(new ItemOnClickListener(cart,heroes[position].get_value("h_id")));
	          } else {
	            cell = (View) convertView;
	          }
	      return cell;

	}
	
	public class ItemOnClickListener implements OnClickListener{
		String h_id;
		
		
		public ItemOnClickListener (CartModel cm, String hid) {
			this.h_id = hid;
			
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//change view to show items 
			//cm.add_item_to_cart(p_id, sc_id);
		}
	}

}
