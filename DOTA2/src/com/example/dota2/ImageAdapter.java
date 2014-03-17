package com.example.dota2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class ImageAdapter extends ArrayAdapter{

	private CartModel cart;
	private Context ctx;
	private Item[] items;
	private Integer sc_id;
	
	public ImageAdapter(Context c, Item[] items)
	{
		super(c, 0);
		ctx=c;
		this.items = items;
		this.cart = new CartModel();
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences((Activity) ctx);
		sc_id = pref.getInt("sc_id", -1);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.length;
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
	            textView.setText(items[position].get_value("p_label")+"\n"+items[position].get_value("p_price"));
	            imageView.setImageBitmap(items[position].get_image());
	            addToCart.setOnClickListener(new ItemOnClickListener(cart,items[position].get_value("p_id"), sc_id));
	          } else {
	            cell = (View) convertView;
	          }
	      return cell;

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
			// TODO Auto-generated method stub
			cm.add_item_to_cart(p_id, sc_id);
		}
	}

}