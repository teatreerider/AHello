package com.example.ahello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingBarTest01 extends Activity {
	RatingBar mRating;
	TextView mRateText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating_bar_test01);

		mRating = (RatingBar)findViewById(R.id.ratingbar);
		mRateText = (TextView)findViewById(R.id.ratetext);

		mRating.setOnRatingBarChangeListener(new 
				RatingBar.OnRatingBarChangeListener() {
			public void onRatingChanged(RatingBar ratingBar, float rating, 
					boolean fromUser) {
				mRateText.setText("Now Rate : " + rating);
			}
		});
	}
}
