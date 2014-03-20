package com.example.dota2;

import java.util.concurrent.ExecutionException;

import android.graphics.Bitmap;
/**
 * Container object to help with abstraction in the rest of our code.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class Item {

	Post p;
	Bitmap image;
	public Item(Post p){
		this.p=p;
		//Retrieve and set Image from server
		set_image(Config.SERVER_URL+get_value("p_image"));
	}
	public void set_image(String url){
		GetImageTask GIT=new GetImageTask();
		try {
			this.image=GIT.execute(url).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
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
