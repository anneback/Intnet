package com.example.dota2;

import java.util.concurrent.ExecutionException;

import android.graphics.Bitmap;
import android.util.Log;

public class Item {
	private static final String URL ="http://130.229.185.48";
	Post p;
	Bitmap image;
	public Item(Post p){
		this.p=p;
		//Retrieve and set Image from server
		Log.d("DEBUGG ITEM",URL+this.get_value("p_image"));
		set_image(URL+this.get_value("p_image"));

	}
	public void set_image(String url){
		GetImageTask GIT=new GetImageTask();
		try {
			this.image=GIT.execute(url).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Bitmap get_image(){
		return image;
	}
	public Post get_post(){
		return p;
	}
	public String get_value(String value_id){
		return p.getPostValue(value_id);
	}

}
