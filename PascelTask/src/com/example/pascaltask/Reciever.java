package com.example.pascaltask;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.content.Intent;

public class Reciever extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_reciever);
		TextView txt1 = (TextView)findViewById(R.id.textView1);
		TextView txt2 = (TextView)findViewById(R.id.textView2);
		TextView txt3 = (TextView)findViewById(R.id.textView3);
		TextView txt4 = (TextView)findViewById(R.id.textView4);
		
		Intent myIntent = getIntent();
		myparcel mParcel = myIntent.getParcelableExtra("myparcel");
		Employee obj = mParcel.getObject();
		
		txt1.setText(obj.getFirst());
		txt2.setText(obj.getLast());
		txt3.setText(""+obj.getAge());
		
		txt4.setText(""+obj.getSal());
	}
}