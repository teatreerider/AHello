package com.example.ahello;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class MenuCheck extends Activity {

	Button mbtn;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_check);
		mbtn = new Button(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.menu_check, menu);
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menucheck, menu);
		return true;
	}
	

	public boolean onPrepareOptionsMenu(Menu menu){
		Log.d("MenuCheck","BigFont - true : " + mbtn.getTextSize());
		if (mbtn.getTextSize() == 40){
			Log.d("MenuCheck","BigFont - true : " + mbtn.getTextSize());	
			
			menu.findItem(R.id.bigfont).setChecked(true);
			
		}else if(mbtn.getTextSize() == 20){
			Log.d("MenuCheck","BigFont - false : " + mbtn.getTextSize());	
			menu.findItem(R.id.bigfont).setChecked(false);
		}
		
		int color = mbtn.getTextColors().getDefaultColor();
		
		if (color == Color.RED) {
			Log.d("MenuCheck","RED");
			menu.findItem(R.id.red).setChecked(true);
		}
		if (color == Color.GREEN) {
			Log.d("MenuCheck","GREEN");
			menu.findItem(R.id.green).setChecked(true);
		}
		if (color == Color.BLUE) {
			menu.findItem(R.id.blue).setChecked(true);
		}
		
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		Log.d("MenuCheck","onOptionItemSelected");	
		switch (item.getItemId()){
		case R.id.bigfont:
			if (item.isChecked()){
				mbtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, 20);
			}else{
				mbtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
			}
			return true;
			
		case R.id.red:
			mbtn.setTextColor(Color.RED);
			Log.d("MenuCheck","RED1");
			return true;
		case R.id.green:
			Log.d("MenuCheck","GREEN1");

			mbtn.setTextColor(Color.GREEN);
			return true;
		case R.id.blue:
			mbtn.setTextColor(Color.BLUE);
			return true;	
		
		}

		return false;
	}

}
