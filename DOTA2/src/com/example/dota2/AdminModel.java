package com.example.dota2;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import android.util.Log;

public class AdminModel {
	private String image_url="http://130.229.128.190/upload.php";
	private String api_url="http://130.229.128.190/test.php";
	
	public AdminModel(){
		
	}
	public void upload_image(String filePath,String filename){
		UploadImageTask uploadThread= new UploadImageTask();
		String[] args={image_url,filePath,filename};
		uploadThread.execute(args);
		
	}
	public void add_item(Post p){
		UploadThreadTask upt = null;
		//String res="";
		Object[] res=null;
		try {
			upt = new UploadThreadTask(api_url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] arr={"add_item",p.getPostValue("p_label"),p.getPostValue("p_desc"),p.getPostValue("p_image"),p.getPostValue("p_hero"),p.getPostValue("p_price")};
		try {
			res = upt.execute(arr).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}	
		Log.d("AdminModel",Arrays.toString(res));
	}
	


}
