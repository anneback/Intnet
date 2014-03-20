package com.example.dota2;


import java.util.ArrayList;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
/**
 * View inflater for showing cart items with information in a listview, with buttons to remove unwanted items.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class CartListAdapter extends ArrayAdapter<Item> {
	private CartModel cart;
	private final Context context;
	private final ArrayList<Item> itemsArrayList;
	private Integer sc_id;

	public CartListAdapter(Context context, ArrayList<Item> itemsArrayList) {
		super(context, R.layout.cart_row, itemsArrayList);
		this.cart = new CartModel();
		this.context = context;
		this.itemsArrayList = itemsArrayList;
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences((Activity) context);
		sc_id = pref.getInt("sc_id", -1);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		ViewHolder holder=null;
		if(convertView==null){
			convertView = inflater.inflate(R.layout.cart_row, parent, false);
			holder=new ViewHolder();
			holder.labelView = (TextView) convertView.findViewById(R.id.label);
			holder.valueView = (TextView) convertView.findViewById(R.id.value);
			holder.quantityView = (TextView) convertView.findViewById(R.id.quantity);
			holder.itemTotalView = (TextView) convertView.findViewById(R.id.item_total);
			holder.addToCart = (Button) convertView.findViewById(R.id.remove_from_cart);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		holder.labelView.setText("Item name: "+itemsArrayList.get(position).get_value("p_label"));
		holder.valueView.setText("Item price: "+itemsArrayList.get(position).get_value("p_price"));
		holder.quantityView.setText("Item quantity: "+itemsArrayList.get(position).get_value("quantity"));
		holder.itemTotalView.setText("Totalling: "+itemsArrayList.get(position).get_value("totalprice"));
		holder.addToCart.setOnClickListener(new ItemOnClickListener(cart,itemsArrayList.get(position).get_value("p_id"), sc_id));
		return convertView;
	}
	public class ViewHolder{
		TextView labelView;
		TextView valueView;
		TextView quantityView;
		TextView itemTotalView;
		Button addToCart;
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
			transaction.commit();
		}
	}
}