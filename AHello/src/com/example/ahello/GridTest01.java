package com.example.ahello;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridTest01 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_test01);
		
		GridView grid = (GridView) findViewById(R.id.grid);
		MyImageAdapter Adapter = new MyImageAdapter(this);
		grid.setAdapter(Adapter);
		
	}

}

class MyImageAdapter extends BaseAdapter{

	private Context mContext;
	int[] picture = {R.drawable.hojun01, R.drawable.ic_launcher, R.drawable.cameron01};
	
	public MyImageAdapter(Context c) {
		mContext = c;
	}

	@Override
	public int getCount() {
		return 100;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		return picture[position%3];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		
		if(convertView==null){
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(45,45));
			imageView.setAdjustViewBounds(false);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		}else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(picture[position % 3]);

		return imageView;
	}
	
}