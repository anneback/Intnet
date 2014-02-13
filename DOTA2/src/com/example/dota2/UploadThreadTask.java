package com.example.dota2;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import android.os.AsyncTask;
import android.util.Log;
import de.timroes.axmlrpc.XMLRPCClient;
import de.timroes.axmlrpc.XMLRPCException;


public class UploadThreadTask extends AsyncTask<String, Integer, Object[]> {
	private  XMLRPCClient client;
	public UploadThreadTask() throws MalformedURLException{
		this.client = new XMLRPCClient(new URL("http://130.229.185.48/test.php"));

	}
	@Override
	protected Object[] doInBackground(String... params) {
		Object[] response = null;
		String[] callargs=new String[10];
		Log.d("UPLOAD",Arrays.toString(params));
		try {
			response = (Object[]) client.call( params[0],params);
		} catch (XMLRPCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  response;
	}
}
