package com.example.dota2;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.support.v4.app.NavUtils;

public class AdminActivity extends Activity {
	private static final int PICK_IMAGE = 1;

	private Button uploadButton;
	private Button selectImageButton;
	private String imageFilePath;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		setupActionBar();
		
		final AdminModel AM= new AdminModel();

		
		uploadButton = (Button) findViewById(R.id.uploadButton);
		uploadButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AM.upload_image(imageFilePath);
			}
		});

		// on click select an image
		selectImageButton = (Button) findViewById(R.id.selectImageButton);
		selectImageButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				selectImageFromGallery();
			}
		});
	
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}
	/**
	 *some help from http://curious-blog.blogspot.se/2013/06/pick-image-and-upload-to-server-in.html
	 *with picture gallery select
	 * Opens dialog picker, so the user can select image from the gallery. The
	 * result is returned in the method <code>onActivityResult()</code>
	 */
	public void selectImageFromGallery() {
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Select Picture"),PICK_IMAGE);
	}
	/**
	 * some help from http://curious-blog.blogspot.se/2013/06/pick-image-and-upload-to-server-in.html
	 * with picture gallery select
	 * Retrives the result returned from selecting image, by invoking the method
	 * <code>selectImageFromGallery()</code>
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };
			Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
			cursor.moveToFirst();
			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			imageFilePath = cursor.getString(columnIndex);
			cursor.close();
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
