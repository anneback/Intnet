package com.example.dota2;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ItemModel {
	ArrayList<Item> items;
	public ItemModel(){
		
	}
	public ArrayList<Item> get_all_items(){
		
		return items;
		
	}
	
/*	UploadThreadTask upt = null;
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
	}*/
}
