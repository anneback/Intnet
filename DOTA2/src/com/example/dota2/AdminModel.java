package com.example.dota2;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import android.util.Log;

public class AdminModel {
	public AdminModel(){
		
	}
	
	public void add_item(Post p){
		UploadThreadTask upt = null;
		//String res="";
		Object[] res=null;
		try {
			upt = new UploadThreadTask();
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
