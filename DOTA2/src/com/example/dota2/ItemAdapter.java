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
/**
 * Custom ArrayAdapter to inflate views of our itemfragment, all items are generated through content taken from php backend.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class ItemAdapter extends ArrayAdapter<Item>{

	private CartModel cart;
	private Context ctx;
	private Item[] items;
	private Integer sc_id;

	public ItemAdapter(Context c, Item[] items)
	{
		super(c, 0);
		ctx=c;
		this.items = items;
		this.cart = new CartModel();
		// Getting access to stored data from the first call to the DB
		// Functions like a cookie
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences((Activity) ctx);
		sc_id = pref.getInt("sc_id", -1); // -1 default value
	}
	@Override
	public int getCount() {
		return items.length;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder; // To not overlap views when generating new view of the same type
		View cell = convertView;
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
			cell = inflater.inflate(R.layout.items_layout, parent, false);
			holder.textView = (TextView) cell.findViewById(R.id.grid_item_label);
			holder.imageView = (ImageView) cell.findViewById(R.id.grid_item_image);
			holder.button = (Button) cell.findViewById(R.id.add_to_cart);
			cell.setTag(holder);

		} else {
			holder =(ViewHolder) convertView.getTag();
		}
		holder.textView.setText(items[position].get_value("p_label")+"\n"+items[position].get_value("p_price"));
		holder.imageView.setImageBitmap(items[position].get_image());
		holder.button.setOnClickListener(new ItemOnClickListener(cart,items[position].get_value("p_id"), sc_id));
		return cell;

	}
	public class ViewHolder{
		TextView textView ;
		ImageView imageView ;
		Button button ;

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
			cm.add_item_to_cart(p_id, sc_id);
		}
	}

}