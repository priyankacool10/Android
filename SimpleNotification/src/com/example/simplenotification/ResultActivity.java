package com.example.simplenotification;



import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;

public class ResultActivity extends Activity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_result);
		TextView output = (TextView)findViewById(R.id.textView1);
		Intent myIntent = getIntent();
		int myNotificationId = myIntent.getIntExtra("myNotificationId",-1);
	
		//Removing notification from top after tap on notification
		if (myNotificationId != -1)
		{
			NotificationManager myManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			myManager.cancel(myNotificationId);
		}
		output.setText("Data sent by first activity: "+myIntent.getIntExtra("AnyValue", -1));
	}
}
