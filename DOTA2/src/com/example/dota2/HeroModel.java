package com.example.dota2;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import android.content.Context;

public class HeroModel {
	Context ctx;
	public HeroModel(Context c){
		ctx= c;
	}
	public ArrayList<Hero> get_all_heroes(){
		ArrayList<Hero> Heroes= new ArrayList<Hero>();
		UploadThreadTask upt = null;
		Object[] res=null;
		try {
			upt = new UploadThreadTask(Config.api_url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String[] arr={"get_heroes"};

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
				Hero i= new Hero(new Post(hm),ctx);
				Heroes.add(i);
			}
		}
		return Heroes;
		
	}


}
