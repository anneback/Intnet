package com.example.dota2;


import java.util.ArrayList;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
public class CartListAdapter extends ArrayAdapter<Item> {
 
        private final Context context;
        private final ArrayList<Item> itemsArrayList;
 
        public CartListAdapter(Context context, ArrayList<Item> itemsArrayList) {
 
            super(context, R.layout.itemrow, itemsArrayList);
 
            this.context = context;
            this.itemsArrayList = itemsArrayList;
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
   
 
            // 4. Set the text for textView
            labelView.setText("Item name: "+itemsArrayList.get(position).get_value("p_label"));
            valueView.setText("Item price: "+itemsArrayList.get(position).get_value("p_price"));
            quantityView.setText("Item quantity: "+itemsArrayList.get(position).get_value("quantity"));
            itemTotalView.setText("Totalling: "+itemsArrayList.get(position).get_value("totalprice"));
         
 
            // 5. retrn rowView
            return rowView;
        }
}