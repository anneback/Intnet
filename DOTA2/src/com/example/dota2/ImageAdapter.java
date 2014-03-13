package com.example.dota2;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	private Context ctx;
	private Item[] items;

	public ImageAdapter(Context c, Item[] items)
	{
		ctx=c;
		this.items = items;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pics.length;
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
		ImageView iv;
		if (convertView == null) {  // if it's not recycled, initialize some attributes
			iv = new ImageView(ctx);
			iv.setLayoutParams(new GridView.LayoutParams(350,350));
			iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
			iv.setPadding(8, 8, 8, 8);
		} else {
			iv = (ImageView) convertView;
		}
		iv.setImageBitmap(items[position].get_image());
		return iv;

	}
	
	private Integer[] pics={
			R.drawable.dota2_logo,R.drawable.heroes_hover,
			R.drawable.items_hover,R.drawable.dragonclawhook
	};
}