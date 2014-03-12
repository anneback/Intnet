package com.example.dota2;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
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
	
	public Integer register_user(String userMail,String userPassword){
		String[] args= new String[3];
		args[0]="register_user";
		args[1]=userMail;
		args[2]=userPassword;
		Object[] res=null;
		try {
			UploadThreadTask upt= new UploadThreadTask(api_url);
			res=upt.execute(args).get();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Object o:res){
			HashMap<String,String> hm=(HashMap<String,String>) o;
			return Integer.parseInt(hm.get("u_id"));
		}
		return 1337;
	}
	public Integer register_shopping_cart(Integer user_id){
		
		String[] args= new String[2];
		args[0]="register_shopping_cart";
		args[1]=user_id.toString();

		Object[] res=null;
		try {
			UploadThreadTask upt= new UploadThreadTask(api_url);
			res=upt.execute(args).get();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Object o:res){
			HashMap<String,String> hm=(HashMap<String,String>) o;
			return Integer.parseInt(hm.get("sc_id"));
		}
		return 1337;
	}

}
