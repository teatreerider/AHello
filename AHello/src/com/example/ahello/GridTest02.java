package com.example.ahello;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class GridTest02 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_test01);
		
		GridView grid = (GridView) findViewById(R.id.grid);
		ImageAdapter Adapter = new ImageAdapter(this);
		grid.setAdapter(Adapter);
		
	}

}

class ImageAdapter extends BaseAdapter{

	private Context mContext;
	ArrayList<String> gArray;
	//int[] picture = {R.drawable.hojun01, R.drawable.ic_launcher, R.drawable.cameron01};
	
	public ImageAdapter(Context c) {
		mContext = c;
		gArray = getThumbData();
	}

	@Override
	public int getCount() {
		return 10;
	}


	@Override
	public long getItemId(int position) {
		return position;
	}
	
	// 
	Cursor getSDImageCursor(){
		String[] proj = {MediaStore.Images.Media._ID,
									MediaStore.Images.Media.DATA,
									MediaStore.Images.Media.DISPLAY_NAME,
									MediaStore.Images.Media.SIZE};
		
		return mContext.getContentResolver().query(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, proj, null, null, null);
	}
	
	ArrayList<String> getThumbData(){
		Cursor imageCursor = getSDImageCursor();
		ArrayList<String> ret = new ArrayList<String>();
		
		if(imageCursor != null && imageCursor.moveToFirst()){
			int data = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
			int id = imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
			
			do{
				if(imageCursor.getString(id)!=null){
					String path = imageCursor.getString(data);
					ret.add(path);
				}
			}while(imageCursor.moveToNext());
		}
		imageCursor.close();
		return ret;
		
	}

	
	public Bitmap getbitmap(ArrayList<String> thumb, int index, int sx, int sy){
		BitmapFactory.Options bo = new BitmapFactory.Options();
		bo.inSampleSize = 8;
		
		Bitmap bmp = BitmapFactory.decodeFile(thumb.get(index),bo);
		Bitmap resized = Bitmap.createScaledBitmap(bmp, sx, sy, true);
		
		return resized;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		
		if(convertView==null){
			imageView = new ImageView(mContext);
			//imageView.setLayoutParams(new GridView.LayoutParams(45,45));
			imageView.setAdjustViewBounds(false);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		}else {
			imageView = (ImageView) convertView;
		}
		
		int sx = 200;
		int sy = 200;
		
		imageView.setAdjustViewBounds(false);
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		imageView.setImageBitmap(getbitmap(gArray, position, sx, sy));
		return imageView;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	
}