package com.example.dota2;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

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
		ViewHolder holder = null;

		View cell = convertView;
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
			cell=inflater.inflate(R.layout.heroes_layout, parent, false);
			holder.txtview=(TextView) cell.findViewById(R.id.hero_name);
			holder.imgbutton= (ImageButton) cell.findViewById(R.id.hero_button);
			cell.setTag(holder);

		} else {
			holder = (ViewHolder)convertView.getTag();

		}
		holder.txtview.setText(heroes[position].get_value("h_name"));
		holder.imgbutton.setImageBitmap(heroes[position].get_image());
		holder.imgbutton.setOnClickListener(new ItemOnClickListener(cart,heroes[position].get_value("h_id")));
		return cell;

	}
	public class ViewHolder{
		public TextView txtview;
		public ImageButton imgbutton;
		
	}
	public class ItemOnClickListener implements OnClickListener{
		String h_id;


		public ItemOnClickListener (CartModel cm, String hid) {
			this.h_id = hid;

		}
		public void onClick(View v) {


			ItemFragment newFragment = new ItemFragment();
			Bundle bundle = new Bundle();
			bundle.putString("h_id", h_id);
			// set Fragmentclass Arguments

			newFragment.setArguments(bundle);
			FragmentTransaction transaction = ((Activity)ctx).getFragmentManager().beginTransaction();

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			transaction.replace(android.R.id.content, newFragment);
			transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();

			Log.d("BUTTON", "Clicked hero #"+h_id+" in list");

		}
	}

}
