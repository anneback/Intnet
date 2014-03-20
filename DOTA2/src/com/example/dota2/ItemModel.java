package com.example.dota2;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
/**
 * ItemModel that supports functions like get_item_by_hero or get_all items, both done via xmlrpc calls to phpbackend.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */
public class ItemModel {

	ArrayList<Item> items;
	public ItemModel(){
		items= new ArrayList<Item>();

	}
	public ArrayList<Item> get_item_by_hero(String h_id){
		ArrayList<Item> items= new ArrayList<Item>();
		UploadThreadTask upt = null;
		Object[] res=null;
		try {
			upt = new UploadThreadTask(Config.api_url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String[] arr={"get_items_by_hero_name",h_id};

		try {
			res = upt.execute(arr).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		if(res!=null){
			for(Object o:res){
				@SuppressWarnings("unchecked")
				HashMap<String,String> hm=(HashMap<String,String>) o;
				Item i= new Item(new Post(hm));
				items.add(i);
			}
		}
		return items;
		
	}
	public ArrayList<Item> get_all_items(){
		UploadThreadTask upt = null;
		Object[] res=null;
		try {
			upt = new UploadThreadTask(Config.api_url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String[] arr={"get_item_category","Items"};

		try {
			res = upt.execute(arr).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		if(res!=null){
			for(Object o:res){
				@SuppressWarnings("unchecked")
				HashMap<String,String> hm=(HashMap<String,String>) o;
				Item i= new Item(new Post(hm));
				items.add(i);
			}
		}
		return items;
	}


}
