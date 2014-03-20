package com.example.dota2;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
/**
 * ArrayAdapter to inflate view and produce dynamic content(retrieved from our server) in a gridview.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class HeroAdapter extends ArrayAdapter<Hero>{
	private CartModel cart;
	private Context ctx;
	private Hero[] heroes;


	public HeroAdapter(Context c, Hero[] heroes)
	{
		super(c, 0);
		ctx=c;
		this.heroes = heroes;
		this.cart = new CartModel();
	}
	@Override
	public int getCount() {
		return heroes.length;
	}

	@Override
	public Hero getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
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
			newFragment.setArguments(bundle);
			FragmentTransaction transaction = ((Activity)ctx).getFragmentManager().beginTransaction();
			transaction.replace(android.R.id.content, newFragment);
			transaction.addToBackStack(null);
			transaction.commit();
		}
	}

}
