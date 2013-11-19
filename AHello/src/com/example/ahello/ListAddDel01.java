package com.example.ahello;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ListAddDel01 extends Activity {
	ArrayList<String> Items;
	ArrayAdapter<String> Adapter;
	ListView list;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_add_del01);

		Items = new ArrayList<String>();
		Items.add("First");
		Items.add("Second");
		Items.add("Third");

		Adapter = new ArrayAdapter<String>(this, android.R.layout.
				simple_list_item_single_choice, Items);
		list = (ListView)findViewById(R.id.list);
		list.setAdapter(Adapter);
		list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}

	public void mOnClick(View v) {
		EditText ed = (EditText)findViewById(R.id.newitem);
		switch (v.getId()) {
		case R.id.add:
			String text = ed.getText().toString();
			if (text.length() != 0) {
				Items.add(text);
				ed.setText("");
				Adapter.notifyDataSetChanged();
			}
			break;
		case R.id.delete:
			int pos;
			pos = list.getCheckedItemPosition();
			if (pos != ListView.INVALID_POSITION) {
				Items.remove(pos);
				list.clearChoices();
				Adapter.notifyDataSetChanged();
			}
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_add_del01, menu);
		return true;
	}

}
