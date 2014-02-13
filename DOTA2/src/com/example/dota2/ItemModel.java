package com.example.dota2;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ItemModel {
	
	ArrayList<Item> items;
	public ItemModel(){
		items= new ArrayList<Item>();
	}
	public ArrayList<Item> get_all_items(){
			UploadThreadTask upt = null;
		//String res="";
		Object[] res=null;
		try {
			upt = new UploadThreadTask();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] arr={"get_item_category","Items"};
		try {
			res = upt.execute(arr).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Object o:res){
			HashMap<String,String> hm=(HashMap<String,String>) o;
			Item i= new Item(new Post(hm));
			items.add(i);
		}
		//
		return items;
		
	}
	

}
