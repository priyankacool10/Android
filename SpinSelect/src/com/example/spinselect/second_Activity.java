package com.example.spinselect;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class second_Activity extends Activity {
	TextView mtextView1,mtextView2,mtextView3;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
		Intent myIntent = getIntent();
		mtextView1=(TextView)findViewById(R.id.mtextView1);
		mtextView2=(TextView)findViewById(R.id.mtextView2);
		mtextView3=(TextView)findViewById(R.id.mtextView3);
		if(myIntent.hasExtra("meditText1")){
			mtextView1.setText("Your name is: "+myIntent.getStringExtra("meditText1"));
		}
		if(myIntent.hasExtra("meditText2")){
			mtextView2.setText("Your Number is: "+myIntent.getStringExtra("meditText2"));
		}
		if(myIntent.hasExtra("spinnerText")){
			mtextView3.setText("Type of Number is: "+myIntent.getStringExtra("spinnerText"));
		}
		
		
		
	}
	


	
}
