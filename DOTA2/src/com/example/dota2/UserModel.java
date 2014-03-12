package com.example.dota2;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class UserModel {
	
	private String api_url="http://130.229.128.190/test.php";
	public UserModel(){
		
	}
	public boolean add_item_to_shopping_cart(Integer sc_id,Integer p_id){
		String[] args = new String[3];
		args[0] = "add_item_to_cart";
		args[1] = p_id.toString();
		args[2] = sc_id.toString();
		UploadThreadTask upt=null;
		try {
			upt = new UploadThreadTask(api_url);
			upt.execute(args);
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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
