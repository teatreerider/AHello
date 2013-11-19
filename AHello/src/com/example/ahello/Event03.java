
package com.example.ahello;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;

public class Event03 extends Activity  implements View.OnTouchListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View vw = new View(this);
		vw.setOnTouchListener(this);
		setContentView(vw);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			Toast.makeText(Event03.this, "Touch Event03 Received", Toast.LENGTH_SHORT).show();
		}
		return false;
	}

}
