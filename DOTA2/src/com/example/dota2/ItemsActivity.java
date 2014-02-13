package com.example.dota2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
            	Context context = getApplicationContext();
					ArrayList<Item> items=IM.get_all_items();
					//EXAMPLE
        			imageView.setImageBitmap(items.get(0).get_image());
            }
        });

    }

}


