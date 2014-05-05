package com.example.jsonparsertask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class ShowNotice extends Activity {
	TextView tv1,tv2;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_shownotice);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		Intent myIntent = getIntent();
		if(myIntent.hasExtra("title")){
			tv1.setText(myIntent.getStringExtra("title"));
		}
		if(myIntent.hasExtra("description")){
			tv2.setText(myIntent.getStringExtra("description"));
		}
		
	}
}
