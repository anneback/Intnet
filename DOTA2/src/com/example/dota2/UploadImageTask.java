package com.example.dota2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
/**
 * Class that handles a simple multipart form sending image data to server,
 * currently not in use in the application.
 * @author Carl Henrik Klåvus chklavus@kth.se
 * @author Jesper Annebäck anneback@kth.se
 */

public class UploadImageTask extends AsyncTask<String, Integer, Integer> {

	public int upload(String urlPath,String filepath,String filename) throws IOException
	{
		//Simple straight forward http post taken from  
		//http://reecon.wordpress.com/2010/04/25/uploading-files-to-http-server-using-post-android-sdk/
		HttpURLConnection connection = null;
		DataOutputStream outputStream = null;


		String pathToOurFile = filepath;
		String urlServer = urlPath;
		String lineEnd = "\r\n";
		String twoHyphens = "--";
		String boundary =  "*****";

		int bytesRead, bytesAvailable, bufferSize;
		byte[] buffer;
		int maxBufferSize = 1*1024*1024;
		int serverResponseCode=0;

		try
		{
			FileInputStream fileInputStream = new FileInputStream(new File(pathToOurFile) );

			URL url = new URL(urlServer);
			connection = (HttpURLConnection) url.openConnection();

			// Allow Inputs & Outputs
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);

			// Enable POST method
			connection.setRequestMethod("POST");

			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);

			outputStream = new DataOutputStream( connection.getOutputStream() );
			outputStream.writeBytes(twoHyphens + boundary + lineEnd);
			outputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + filename +"\"" + lineEnd);
			outputStream.writeBytes(lineEnd);

			bytesAvailable = fileInputStream.available();
			bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];

			// Read file
			bytesRead = fileInputStream.read(buffer, 0, bufferSize);

			while (bytesRead > 0)
			{
				outputStream.write(buffer, 0, bufferSize);
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			}

			outputStream.writeBytes(lineEnd);
			outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

			// Responses from the server (code and message)
			serverResponseCode = connection.getResponseCode();
			//	String serverResponseMessage = connection.getResponseMessage();

			fileInputStream.close();
			outputStream.flush();
			outputStream.close();
		}
		catch (Exception ex)
		{
			//Exception handling
		}
		return serverResponseCode;
	}

	protected Integer doInBackground(String... params) {
		int returnCode=0;
		try {
			returnCode=upload(params[0],params[1],params[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnCode;

	}
}
