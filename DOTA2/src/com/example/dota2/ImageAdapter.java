package com.example.dota2;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class ImageAdapter extends ArrayAdapter {

	private Context ctx;
	private Item[] items;

	public ImageAdapter(Context c, Item[] items)
	{
		super(c, 0);
		ctx=c;
		this.items = items;
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
	            ImageView imageView = (ImageView)cell.findViewById(R.id.grid_item_image);
	            textView.setText(items[position].get_value("p_label")+"\n"+items[position].get_value("p_price"));
	            imageView.setImageBitmap(items[position].get_image());
	          } else {
	            cell = (View) convertView;
	          }
	      return cell;

	}
	
	private Integer[] pics={
			R.drawable.dota2_logo,R.drawable.heroes_hover,
			R.drawable.items_hover,R.drawable.dragonclawhook
	};
}