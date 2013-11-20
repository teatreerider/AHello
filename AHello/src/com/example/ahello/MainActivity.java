package com.example.ahello; // 깃 하자 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button btn;
	Button btnEvent2;
	Button btnEvent3;
	Button btnEvent5;
	Button btnFreeLine;
	Button btnDraw;
	Button btnListAddDel;
	Button btnOverScroll;
	Button btnGridTest01;
	Button btnGridTest02;
	Button btnRatingBar01;
	LinearLayout ll;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		btn = new Button(this);
		btn.setText("MenuCheck");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MenuCheck.class);
				startActivity(intent);
			}
		});
		
		btnEvent2= new Button(this);
		btnEvent2.setText("Event02");
		btnEvent2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Event02.class);
				startActivity(intent);
			}
		});
		
		btnEvent3 = new Button(this);
		btnEvent3.setText("Event03");
		btnEvent3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Event03.class);
				startActivity(intent);
			}
		});
		
	
		btnEvent5 = new Button(this);
		btnEvent5.setText("Event05");
		btnEvent5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Event05.class);
				startActivity(intent);
			}
		});
		
		btnFreeLine = new Button(this);
		btnFreeLine.setText("FreeLine");
		btnFreeLine.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, FreeLine.class);
				startActivity(intent);
			}
		});
		
		btnDraw = new Button(this);
		btnDraw.setText("DrawUndoRedo");
		btnDraw.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Draw.class);
				startActivity(intent);
			}
		});
		
		btnListAddDel = new Button(this);
		btnListAddDel.setText("ListAddDell");
		btnListAddDel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ListAddDel01.class);
				startActivity(intent);
			}
		});
		
		btnOverScroll = new Button(this);
		btnOverScroll.setText("OverScroll");
		btnOverScroll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, OverScroll.class);
				startActivity(intent);
				
			}
		});
		
		btnGridTest01 = new Button(this);
		btnGridTest01.setText("GridTest01");
		btnGridTest01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, GridTest01.class);
				startActivity(intent);
			}
		});
		
		btnGridTest02 = new Button(this);
		btnGridTest02.setText("GridTest02");
		btnGridTest02.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, GridTest02.class);
				startActivity(intent);
			}
		});
		
		btnRatingBar01 = new Button(this);
		btnRatingBar01.setText("RatingBar");
		btnRatingBar01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, RatingBarTest01.class);
				startActivity(intent);
			}
		});
		
		
		ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		ll.addView(btn);
		ll.addView(btnEvent2);
		ll.addView(btnEvent3);
		ll.addView(btnEvent5);
		ll.addView(btnFreeLine);
		ll.addView(btnDraw);
		ll.addView(btnListAddDel);
		ll.addView(btnOverScroll);
		ll.addView(btnGridTest01);
		ll.addView(btnGridTest02);
		ll.addView(btnRatingBar01);
		
		
		setContentView(ll);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		MenuItem item=menu.add(0,1,0,"x");
		item.setIcon(R.drawable.ic_launcher);
		item.setAlphabeticShortcut('a');
		//menu.add(0,1,0,"짜장").setIcon(R.drawable.ic_launcher).setAlphabeticShortcut('a');
		
		menu.add(0,2,0,"y").setIcon(R.drawable.ic_launcher);
		
		SubMenu etc = menu.addSubMenu("z");
		etc.add(0,3,0,"sub1");
		etc.add(0,4,0,"sub2");

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this,"This is X",Toast.LENGTH_SHORT).show();
			return true;
		case 2:
			Toast.makeText(this,"This is Y",Toast.LENGTH_SHORT).show();
			return true;
		case 3:
			Toast.makeText(this,"This is Z",Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
}
