package com.arax.motorcalc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.arax.motorcalc.data.Answer;
import com.arax.motorcalc.ui.AnswerAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;



public class AnswerActivity extends RoboActivity {

	public static final int RESULT_DELETE = -500;

	@InjectView(R.id.notesListView) ListView answerList;

	
	private int imageId;
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
	
		super.onCreateContextMenu(menu, v, menuInfo);
		
		//MenuInflater inflater =getMenuInflater();
		//inflater.inflate(R.menu.context_menu,menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		return true;
		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
	
		getMenuInflater().inflate(R.menu.delete_menu, menu);
		return true;
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer);
	     Intent intent = getIntent();
		  
	        // 2. get person object from intent
	        Answer answer = (Answer) intent.getSerializableExtra("answer");
	        imageId=answer.getTypeResurceId();
	        
			 AnswerAdapter adapter = new AnswerAdapter(this, answer.getItems());
			 answerList.setAdapter(adapter);}

	
	private void showFile(File f) {
		Uri uri = Uri.fromFile(f);
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(uri, "image/*");
		
		startActivity(intent);
	}

	private File cacheFile(Integer resourceId) {
		String imageUri = "drawable://" +resourceId;
		ImageLoader imageLoader = ImageLoader.getInstance();

	File f=	imageLoader.getDiskCache().get(imageUri);

   
	if(!f.exists()){
	
		try {
			
			Bitmap bitmap=	imageLoader.loadImageSync(imageUri);
			
    	    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 40, bytes);
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            fo.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return f;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
//		AlertDialog.Builder builder=new AlertDialog.Builder(this);
//		
//		builder.setMessage(R.string.are_you_sure_);
//		builder.setTitle(R.string.confirm_delete);
//		builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//			
//				Intent retIntent=new Intent();
//				setResult(RESULT_DELETE,retIntent);
//				finish();
//			}
//			
//		
//		});
//		
//		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		
//		});
//		
//		builder.create().show();

		File f=cacheFile(imageId);
		showFile(f);
		return true;
		
	}
	

	}


