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
	public UploadThreadTask(String url) throws MalformedURLException{
		this.client = new XMLRPCClient(new URL(url));

	}
	@Override
	protected Object[] doInBackground(String... params) {
		Object[] response = null;
		Object o=null;
		Log.d("UPLOAD",Arrays.toString(params));
		try {
			o= client.call( params[0],params);
			if(o instanceof Object[]){
				response=(Object[])o;
			}
		} catch (XMLRPCException e) {
			e.printStackTrace();

		}
		return  response;
	}
}

