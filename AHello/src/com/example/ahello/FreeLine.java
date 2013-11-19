package com.example.ahello;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class FreeLine extends Activity {
	
	private MyView mv;
	ArrayList<Vertex> av;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mv = new MyView(this);
		setContentView(mv);
		
		av = new ArrayList<Vertex>();
	}
	
	public class Vertex{
		float x;
		float y;
		boolean draw;
		Vertex(float ax, float ay, boolean ad){
			x= ax;
			y= ay;
			draw = ad;
		}
	}
	
	protected class MyView extends View{

			Paint mp;
			
		public MyView(Context context) {
			super(context);
			
			mp = new Paint();
			mp.setColor(Color.CYAN);
			mp.setStrokeWidth(10);
			mp.setAntiAlias(true);
		}
		public void onDraw(Canvas cv){
			cv.drawColor(Color.BLACK);
			
			for(int i=0; i<av.size(); i++){
				if(av.get(i).draw){
					cv.drawLine(av.get(i-1).x, av.get(i-1).y,av.get(i).x, av.get(i).y, mp);
				}
			}
		}
		
		public boolean onTouchEvent(MotionEvent ev){
			if(ev.getAction()==MotionEvent.ACTION_DOWN){
				av.add(new Vertex(ev.getX(),ev.getY(), false));
				return true;
			}
			if(ev.getAction()==MotionEvent.ACTION_MOVE){
				av.add(new Vertex(ev.getX(),ev.getY(),true));
				invalidate();
				return true;
			}
			
			return false;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.free_line, menu);
		return true;
	}

}
