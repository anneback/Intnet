package com.example.dota2;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import android.util.Log;
/**
 * Model that supports adding a new item to dota2 shoppe database.
 * Currently not used in the application
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class AdminModel {
	public AdminModel(){
		
	}
	public void upload_image(String filePath,String filename){
		UploadImageTask uploadThread= new UploadImageTask();
		String[] args={Config.image_url,filePath,filename};
		uploadThread.execute(args);
		
	}
	public void add_item(Post p){
		UploadThreadTask upt = null;
		Object[] res=null;
		try {
			upt = new UploadThreadTask(Config.api_url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String[] arr={"add_item",p.getPostValue("p_label"),p.getPostValue("p_desc"),p.getPostValue("p_image"),p.getPostValue("p_hero"),p.getPostValue("p_price")};
		try {
			res = upt.execute(arr).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();	
		}	
		Log.d("AdminModel",Arrays.toString(res));
	}
	


}
