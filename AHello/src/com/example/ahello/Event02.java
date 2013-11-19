package com.example.ahello;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Event02 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View vw = new View(this);
		vw.setOnTouchListener(ml);
		setContentView(vw);
		
		
	}

	class MyListener implements View.OnTouchListener{

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(event.getAction()==MotionEvent.ACTION_DOWN){
				Toast.makeText(Event02.this, "Touch Event Received", Toast.LENGTH_SHORT).show();
			}
			return false;
		}
	}
	MyListener ml = new MyListener();
}
