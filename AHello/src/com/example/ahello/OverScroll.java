package com.example.ahello;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OverScroll extends Activity {
	ArrayList<String> mItem = new ArrayList<String>();
	ArrayAdapter<String> mAdapter;
	ListView mList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_over_scroll);
		
		for(int i =1000; i<=1003; i++){
			mItem.add(Integer.toString(i));
		}
		mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mItem);
		mList = (ListView) findViewById(R.id.list);
		mList.setAdapter(mAdapter);
	}
	

	public void mOnClick(View v){
		switch (v.getId()) {
		case R.id.btn3:
			mItem.clear();
			for (int i = 1001; i <= 1003; i++) {
				mItem.add(Integer.toString(i));
			}
			mAdapter.notifyDataSetChanged();
			break;
		case R.id.btn10:
			mItem.clear();
			for (int i = 1001;i <= 1010; i++) {
				mItem.add(Integer.toString(i));
			}
			mAdapter.notifyDataSetChanged();
			break;
		case R.id.btnalways:
			mList.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
			break;
		case R.id.btnnever:
			mList.setOverScrollMode(View.OVER_SCROLL_NEVER);
			break;
		case R.id.btnifscroll:
			mList.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS );
			break;
		}	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.over_scroll, menu);
		return true;
	}

}
