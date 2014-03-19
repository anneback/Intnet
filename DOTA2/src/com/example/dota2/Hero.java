package com.example.dota2;

import java.util.concurrent.ExecutionException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

public class Hero {

	Post p;
	Bitmap image;
	Context ctx;
	public Hero(Post p,Context ctx){
		this.p=p;
		this.ctx=ctx;
		//Retrieve and set Image from server
		int imageResource = ctx.getResources().getIdentifier(get_value("h_image"), null, ctx.getPackageName());
		image = BitmapFactory.decodeResource(ctx.getResources(), imageResource);
		//set_image(Config.SERVER_URL+get_value("h_image"));
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
