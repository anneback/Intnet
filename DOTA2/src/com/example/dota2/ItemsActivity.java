package com.example.dota2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ItemsActivity extends Activity{
	
	
	private ImageView imageView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.items_layout);
        
        imageView = (ImageView) findViewById(R.id.imageView1);
        Button button = (Button) findViewById(R.id.button1);
        final ItemModel IM=new ItemModel();
  
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
					ArrayList<Item> items=IM.get_all_items();
					//EXAMPLE
        			imageView.setImageBitmap(items.get(0).get_image());
            }
        });

    }

}


