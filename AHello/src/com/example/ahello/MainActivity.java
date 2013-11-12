package com.example.ahello;

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
	TextView tv;
	LinearLayout ll;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		
		btn = new Button(this);
		btn.setText("MecuCheck");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MenuCheck.class);
				startActivity(intent);
			}
		});
		
		tv = new TextView(this);
		tv.setText("Press menu.");
		
		ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		ll.addView(btn);
		ll.addView(tv);
		
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
