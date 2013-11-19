package com.example.ahello;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Event05 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		View vw = new View(this);
		vw.setOnTouchListener(myListener);
		setContentView(vw);
	}
	
	private View.OnTouchListener myListener = new View.OnTouchListener(){
		public boolean onTouch (View v, MotionEvent event){
			if(event.getAction()==MotionEvent.ACTION_DOWN){
				Toast.makeText(Event05.this, "Touch Event05 Received", Toast.LENGTH_SHORT).show();
			}
			return false;
		}
	};

}
