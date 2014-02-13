package com.example.dota2;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
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
			try {
				response = (Object[]) client.call( params[0],params[1]);
			} catch (XMLRPCException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  response;
		}
	}
