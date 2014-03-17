package com.example.dota2;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class CartModel {
	private String api_url="http://130.229.143.175/test.php";
	private ArrayList<Item> cartItems;
	public CartModel(){
		cartItems= new ArrayList<Item>();
	}
	public int get_total_price(){
		int sum=0;
		for(Item i:cartItems){
			sum=sum+Integer.parseInt(i.get_value("totalprice"));
		}
		return sum;
	}
	
	public void add_item_to_cart(String p_id,Integer sc_id){
		String args[]= new String[3];
		args[0]="add_item_to_cart";
		args[1]=p_id;
		args[2]=sc_id.toString();
	
		UploadThreadTask upt;
		try {
			upt = new UploadThreadTask(api_url);
			upt.execute(args);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Item> get_shopping_cart_information(Integer sc_id){
		String args[]= new String[2];
		args[0]="total_price_for_shopping_cart";
		args[1]=sc_id.toString();
		Object[] res=null;
		try {
			UploadThreadTask upt = new UploadThreadTask(api_url);
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
		if(res!=null){
			for(Object o:res){
				@SuppressWarnings("unchecked")
				HashMap<String,String> hm=(HashMap<String,String>) o;
				Item i= new Item(new Post(hm));
				cartItems.add(i);
			}
		}
		return cartItems;

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
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		for(Object o:res){
			@SuppressWarnings("unchecked")
			HashMap<String,String> hm=(HashMap<String,String>) o;
			return Integer.parseInt(hm.get("sc_id"));
		}
		return 1337;
	}
	public void buyCart(){
		//TODO IMPLEMENT
	}

}
