package com.example.dota2;

import java.util.HashMap;

public class Post {
	private HashMap<String,String> postData;
	public Post(){
		postData=new HashMap<String,String>();
	}
	public Post(HashMap<String,String> otherPost){
		postData=otherPost;
	}
	public HashMap<String,String> get_postData(){
		return postData;
	}
	public String getPostValue(String stringID){
		return postData.get(stringID);
	}
	public void setPostValue(String stringID,String value){
		postData.put(stringID, value);
	}
}
